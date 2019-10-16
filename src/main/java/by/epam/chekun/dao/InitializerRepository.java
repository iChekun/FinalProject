package by.epam.chekun.dao;


import by.epam.chekun.dao.core.JdbcOperations;
import by.epam.chekun.dao.core.impl.JdbcTemplate;

public class InitializerRepository {

    protected JdbcOperations jdbcTemplate;

    public InitializerRepository() {
        this.jdbcTemplate = new JdbcTemplate();
    }
}
