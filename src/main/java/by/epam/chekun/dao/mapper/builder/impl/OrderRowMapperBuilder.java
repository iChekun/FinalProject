package by.epam.chekun.dao.mapper.builder.impl;

import by.epam.chekun.dao.mapper.builder.RowMapperBuilder;
import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.OrderStatus;
import by.epam.chekun.domain.entity.order.PaymentMethod;
import by.epam.chekun.domain.util.builder.order.impl.OrderBuilderImpl;
import by.epam.chekun.domain.util.builder.order.impl.OrderStatusBuilderImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OrderRowMapperBuilder implements RowMapperBuilder<Order> {

    private final int ORDER_ID;
    private final int PAYMENT_METHOD_ID;
    private final int PAYMENT_METHOD_NAME;
    private final int ORDER_STATUS_ID;
    private final int ORDER_STATUS_NAME;
    private final int ORDER_COST;
    private final int ORDER_DATE;


    public OrderRowMapperBuilder(int ORDER_ID, int PAYMENT_METHOD_ID,
                                 int PAYMENT_METHOD_NAME, int ORDER_STATUS_ID,
                                 int ORDER_STATUS_NAME, int ORDER_COST, int ORDER_DATE) {
        this.ORDER_ID = ORDER_ID;
        this.PAYMENT_METHOD_ID = PAYMENT_METHOD_ID;
        this.PAYMENT_METHOD_NAME = PAYMENT_METHOD_NAME;
        this.ORDER_STATUS_ID = ORDER_STATUS_ID;
        this.ORDER_STATUS_NAME = ORDER_STATUS_NAME;
        this.ORDER_COST = ORDER_COST;
        this.ORDER_DATE = ORDER_DATE;
    }

    @Override
    public Order getBuiltEntity(ResultSet set) throws SQLException {
        return buildOrder(set);
    }

    private Order buildOrder(ResultSet set) throws SQLException {
        ////
        final OrderStatus orderStatus = getOrderStatus(set);
        ////
        final PaymentMethod paymentMethod = getPaymentMethod(set);
        ////
        return getOrder(set, orderStatus, paymentMethod);
    }

    private Order getOrder(ResultSet set,
                           OrderStatus orderStatus,
                           PaymentMethod paymentMethod) throws SQLException {
        final String orderId = set.getString(ORDER_ID);
        final double orderCost = set.getDouble(ORDER_COST);
        final Timestamp orderDate = set.getTimestamp(ORDER_DATE);
        //
        return
                new OrderBuilderImpl(orderId)
                        .withOrderStatus(orderStatus)
                        .withPaymentMethod(paymentMethod)
                        .withCost(orderCost)
                        .withOrderDate(orderDate)
                        .build();
    }

    private PaymentMethod getPaymentMethod(ResultSet set) throws SQLException {
        return
                new PaymentMethodRowMapperBuilder(PAYMENT_METHOD_ID, PAYMENT_METHOD_NAME)
                        .getBuiltEntity(set);
    }

    private OrderStatus getOrderStatus(ResultSet set) throws SQLException {
        final String orderStatusId = set.getString(ORDER_STATUS_ID);
        final String orderStatusName = set.getString(ORDER_STATUS_NAME);
        //
        return
                new OrderStatusBuilderImpl(orderStatusId)
                        .withOrderStatusName(orderStatusName)
                        .build();
    }


}
