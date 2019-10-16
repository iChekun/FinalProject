package by.epam.chekun.dao.mapper.builder.impl;

import by.epam.chekun.dao.mapper.builder.RowMapperBuilder;
import by.epam.chekun.domain.entity.order.PaymentMethod;
import by.epam.chekun.domain.util.builder.paymentmethod.impl.PaymentMethodBuilderImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMethodRowMapperBuilder implements RowMapperBuilder<PaymentMethod> {

    private final int PAYMENT_METHOD_ID;
    private final int PAYMENT_METHOD_NAME;

    public PaymentMethodRowMapperBuilder(int PAYMENT_METHOD_ID, int PAYMENT_METHOD_NAME) {
        this.PAYMENT_METHOD_ID = PAYMENT_METHOD_ID;
        this.PAYMENT_METHOD_NAME = PAYMENT_METHOD_NAME;
    }

    @Override
    public PaymentMethod getBuiltEntity(final ResultSet set) throws SQLException {
        return buildPaymentMethod(set);
    }


    private PaymentMethod buildPaymentMethod(ResultSet set) throws SQLException {
        final String paymentMethodId = set.getString(PAYMENT_METHOD_ID);
        final String paymentMethodName = set.getString(PAYMENT_METHOD_NAME);
        //
        //
        return getPaymentMethod(paymentMethodId, paymentMethodName);
    }

    private PaymentMethod getPaymentMethod(String paymentMethodId, String paymentMethodName) {
        return new PaymentMethodBuilderImpl(paymentMethodId)
                .withName(paymentMethodName)
                .build();
    }
}
