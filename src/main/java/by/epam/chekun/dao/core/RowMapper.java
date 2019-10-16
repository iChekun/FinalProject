package by.epam.chekun.dao.core;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T mapRow(ResultSet set) throws SQLException;
}

