package by.epam.chekun.dao.core.impl;

import by.epam.chekun.dao.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ArgumentPreparedStatementSetter implements PreparedStatementSetter {

    private final Object[] argc;


    public ArgumentPreparedStatementSetter(Object[] argc) {
        this.argc = argc;
    }

    @Override
    public void setValues(PreparedStatement ps) throws SQLException {

        if (this.argc != null) {
            for (int i = 0; i < this.argc.length; i++) {
                Object arg = this.argc[i];
                this.doSetValue(ps, i + 1, arg);
            }
        }
    }

    private void doSetValue(PreparedStatement ps, int parameterPosition, Object argValue) throws SQLException {
        set(ps, parameterPosition, argValue);
    }


    private void set(PreparedStatement ps, int parameterPosition, Object argValue) throws SQLException {
        if (argValue instanceof String || argValue == null) {
            ps.setString(parameterPosition, (String) argValue);
        } else if (argValue instanceof Integer) {
            ps.setInt(parameterPosition, (Integer) argValue);
        } else if (argValue instanceof Double) {
            ps.setDouble(parameterPosition, (Double) argValue);
        } else if (argValue instanceof Boolean) {
            ps.setBoolean(parameterPosition, (Boolean) argValue);
        } else if (argValue instanceof Timestamp) {
            ps.setTimestamp(parameterPosition, (Timestamp) argValue);
        } else if (argValue instanceof Long) {
            ps.setLong(parameterPosition, (Long) argValue);
        }
//        else if (argValue == null) {
////            Integer sqlTypeToUse = ps.getParameterMetaData().getParameterType(parameterPosition);
////            ps.setNull(parameterPosition, 12);
//            ps.setString(parameterPosition, argValue);
//        }
    }

    boolean isString(Class<?> inValueType) {
        return CharSequence.class.isAssignableFrom(inValueType);//|| StringWriter.class.isAssignableFrom(inValueType);
    }
}
