package by.epam.chekun.controller.listener;


import by.epam.chekun.dao.core.pool.impl.DatabaseConnectionPool;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {
    private static final String DRIVER = "db.driver";
    private static final String URL = "db.url";
    private static final String USER = "db.user";
    private static final String PASSWORD = "db.password";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final ServletContext servletContext = servletContextEvent.getServletContext();
        final String driver = servletContext.getInitParameter(DRIVER);
        final String url = servletContext.getInitParameter(URL);
        final String user = servletContext.getInitParameter(USER);
        final String password = servletContext.getInitParameter(PASSWORD);
        //
        final DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        pool.init(driver, url, user, password);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        DatabaseConnectionPool.getInstance().destroyPool();
    }
}
