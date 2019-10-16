package by.epam.chekun.dao.core.pool.connection;




import by.epam.chekun.dao.core.pool.ConnectionPool;
import by.epam.chekun.dao.core.pool.impl.DatabaseConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class ProxyConnection implements AutoCloseable {
    private ConnectionWrapper connectionWrapper;

    private ConnectionPool pool = DatabaseConnectionPool.getInstance();


    public ProxyConnection(Connection connection) {
        this.connectionWrapper = new ConnectionWrapper(connection);
    }

    @Override
    public void close() {
        pool.putBackConnection(this);
    }


    public ConnectionWrapper getConnectionWrapper() {
        return connectionWrapper;
    }


    public void destroy() {
        try {
            this.connectionWrapper.realClose();
        } catch (SQLException ignore) { /*NOP*/}
    }
}
