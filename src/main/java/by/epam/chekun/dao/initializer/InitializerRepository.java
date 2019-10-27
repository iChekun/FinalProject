package by.epam.chekun.dao.initializer;


import by.epam.chekun.dao.core.JdbcOperations;
import by.epam.chekun.dao.core.impl.JdbcTemplate;

/**
 * Base class with protected reference on {@code JdbcTemplate}.
 * All repository must extend of initialRepository
 */
public class InitializerRepository {

    protected JdbcOperations jdbcTemplate;

    public InitializerRepository() {
        this.jdbcTemplate = new JdbcTemplate();
    }
}
