package by.epam.chekun.dao.core;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementCallBack<T> {

    T doInPreparedStatement(PreparedStatement ps) throws SQLException;
}
