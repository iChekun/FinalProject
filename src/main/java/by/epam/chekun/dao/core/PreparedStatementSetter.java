package by.epam.chekun.dao.core;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public interface PreparedStatementSetter {
    void setValues(PreparedStatement statement) throws SQLException;
}

