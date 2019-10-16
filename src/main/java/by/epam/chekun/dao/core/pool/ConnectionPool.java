package by.epam.chekun.dao.core.pool;


import by.epam.chekun.dao.core.pool.connection.ProxyConnection;

public interface ConnectionPool {

    ProxyConnection getConnection();

    void putBackConnection(ProxyConnection connection);

    void destroyPool();
}

