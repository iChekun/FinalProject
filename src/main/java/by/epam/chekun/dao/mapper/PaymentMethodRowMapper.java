package by.epam.chekun.dao.mapper;

import by.epam.chekun.dao.core.RowMapper;
import by.epam.chekun.dao.mapper.builder.impl.PaymentMethodRowMapperBuilder;
import by.epam.chekun.domain.entity.order.PaymentMethod;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMethodRowMapper implements RowMapper<PaymentMethod> {

    private static final int PAYMENT_METHOD_ID = 1;
    private static final int PAYMENT_METHOD_NAME = 2;

    @Override
    public PaymentMethod mapRow(ResultSet set) throws SQLException {
        return
                new PaymentMethodRowMapperBuilder
                        (PAYMENT_METHOD_ID, PAYMENT_METHOD_NAME)
                        .getBuiltEntity(set);
    }
}
