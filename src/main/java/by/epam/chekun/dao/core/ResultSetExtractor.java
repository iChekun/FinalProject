package by.epam.chekun.dao.core;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetExtractor<T> {
    T extractData(ResultSet set) throws SQLException;
}
