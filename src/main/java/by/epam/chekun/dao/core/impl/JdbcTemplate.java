package by.epam.chekun.dao.core.impl;

import by.epam.chekun.dao.core.*;
import by.epam.chekun.dao.core.exception.JdbcTemplateException;
import by.epam.chekun.dao.core.pool.connection.ConnectionWrapper;
import by.epam.chekun.dao.core.pool.connection.ProxyConnection;
import by.epam.chekun.dao.core.pool.impl.DatabaseConnectionPool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplate implements JdbcOperations {

    @Override
    public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... argc) throws JdbcTemplateException {
        List<T> results = this.query(sql, rowMapper, argc);
        return getSingleResult(results);
    }

    private <T> T getSingleResult(List<T> results) {
        if (results.size() > 0) {
            return results.get(0);
        }
        return null;
    }

    @Override
    public boolean queryForObject(String sql, Object... argc) throws JdbcTemplateException {
        return this.query(
                new SimplePreparedStatementCreator(sql),
                this.newArgPreparedStatementSetter(argc));
    }


    @Override
    public int update(String sql, Object... argc) throws JdbcTemplateException {
        return this.update(new SimplePreparedStatementCreator(sql),
                this.newArgPreparedStatementSetter(argc));
    }


    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... argc) throws JdbcTemplateException {
        return (List<T>) (this.query(
                new SimplePreparedStatementCreator(sql),
                new RowMapperResultSetExtractor<>(rowMapper),
                this.newArgPreparedStatementSetter(argc)));
    }

    private <T> List<T> query(String sql, Object[] argc, ResultSetExtractor<T> rse) throws JdbcTemplateException {
        return (List<T>) this.query(sql, this.newArgPreparedStatementSetter(argc), rse);
    }

    private <T> T query(String sql, PreparedStatementSetter pss, ResultSetExtractor<T> rse) throws JdbcTemplateException {
        return this.query(new SimplePreparedStatementCreator(sql), pss, rse);
    }


    private <T> T query(PreparedStatementCreator psc, PreparedStatementSetter pss, ResultSetExtractor<T> rse) throws JdbcTemplateException {
        return this.execute(psc, new PreparedStatementCallBack<T>() {
            @Override
            public T doInPreparedStatement(PreparedStatement ps) throws SQLException {
                ResultSet set = null;
                T result;
                try {
                    if (pss != null) {
                        pss.setValues(ps);
                    }

                    set = ps.executeQuery();
                    result = rse.extractData(set);
                } finally {
                    JdbcUtils.closeResultSet(set);
                }

                return result;
            }

        });
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper) throws JdbcTemplateException {
        return (List<T>) (this.query(
                new SimplePreparedStatementCreator(sql),
                new RowMapperResultSetExtractor<>(rowMapper)));
    }

    private <T> T query(PreparedStatementCreator psc, ResultSetExtractor<T> rse) throws JdbcTemplateException {
        return this.query(psc, (PreparedStatementSetter) null, rse);
    }


    private <T> List<T> query(PreparedStatementCreator psc,
                              ResultSetExtractor<T> resultSetExtractor,
                              PreparedStatementSetter pss)
            throws JdbcTemplateException {

        class QueryStatementCallBack implements PreparedStatementCallBack<T> {
            QueryStatementCallBack() {
            }

            @Override
            public T doInPreparedStatement(PreparedStatement ps) throws SQLException {

                if (pss != null) {
                    pss.setValues(ps);
                }

                ResultSet set = null;

                T var;
                try {
                    set = ps.executeQuery();

                    var = resultSetExtractor.extractData(set);
                } finally {
                    JdbcUtils.closeResultSet(set);
                }
                return var;
            }
        }

        return (List<T>) this.execute(psc, new QueryStatementCallBack());
    }


    private <T> T execute(PreparedStatementCreator psc, PreparedStatementCallBack<T> action) throws JdbcTemplateException {

        ProxyConnection proxyConnection = ConnectionCreator.getProxyConnection();
        ConnectionWrapper connectionWrapper = proxyConnection.getConnectionWrapper();
        PreparedStatement ps = null;

        try {
            ps = psc.createPreparedStatement(connectionWrapper);

            T result = action.doInPreparedStatement(ps);

            return result;
        } catch (SQLException e) {
            throw new JdbcTemplateException(e);
        } finally {
            JdbcUtils.closePreparedStatement(ps);
            JdbcUtils.closeConnection(proxyConnection);
        }
    }


    private boolean query(PreparedStatementCreator psc, PreparedStatementSetter pss)
            throws JdbcTemplateException {


        try (ProxyConnection proxyConnection = DatabaseConnectionPool.getInstance().getConnection();
             ConnectionWrapper connectionWrapper = proxyConnection.getConnectionWrapper();
             PreparedStatement statement = psc.createPreparedStatement(connectionWrapper);) {

            pss.setValues(statement);

            ResultSet set = statement.executeQuery();

            return set.first();
        } catch (SQLException e) {
            throw new JdbcTemplateException(e);
        }

    }

    private int update(PreparedStatementCreator psc,
                       PreparedStatementSetter pss) throws JdbcTemplateException {
        return this.execute(psc, (preparedStatement) -> {
            if (pss != null) {
                pss.setValues(preparedStatement);
            }

            int rows = preparedStatement.executeUpdate();

            return rows;
        });
    }


    private static class SimplePreparedStatementCreator implements PreparedStatementCreator {

        private final String sql;

        SimplePreparedStatementCreator(String sql) {
            this.sql = sql;
        }

        @Override
        public PreparedStatement createPreparedStatement(ConnectionWrapper connectionWrapper) throws SQLException {
            return connectionWrapper.prepareStatement(this.sql);
        }

        public String getSql() {
            return sql;
        }
    }


    private static class ConnectionCreator {

        private static final DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();

        private static ProxyConnection getProxyConnection() {
            return pool.getConnection();
        }

        private ConnectionCreator() {
        }
    }



    private PreparedStatementSetter newArgPreparedStatementSetter(Object[] argc) {
        return new ArgumentPreparedStatementSetter(argc);
    }


}
