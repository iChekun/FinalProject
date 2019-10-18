package by.epam.chekun.dao.core.impl;

import by.epam.chekun.dao.core.pool.connection.ProxyConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class JdbcUtils {

    private static final Logger logger = LogManager.getLogger(JdbcUtils.class);


    private JdbcUtils() {

    }


    public static void closeConnection(ProxyConnection proxyConnection) {
        if (proxyConnection != null) {
            proxyConnection.close();
        }
    }

    public static void closePreparedStatement(PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException var2) {
                logger.error("Could not close JDBC Statement", var2);
            } catch (Throwable var3) {
                logger.error("Unexpected exception on closing JDBC Statement", var3);
            }
        }

    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException var2) {
                logger.error("Could not close JDBC ResultSet", var2);
            } catch (Throwable var3) {
                logger.error("Unexpected exception on closing JDBC ResultSet", var3);
            }
        }
    }


}