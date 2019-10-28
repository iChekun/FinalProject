package by.epam.chekun.dao.mapper.builder.impl;

import by.epam.chekun.dao.mapper.builder.RowMapperBuilder;
import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.OrderStatus;
import by.epam.chekun.domain.entity.order.PaymentMethod;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.util.builder.order.impl.OrderBuilderImpl;
import by.epam.chekun.domain.util.builder.order.impl.OrderStatusBuilderImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OrderRowMapperBuilder implements RowMapperBuilder<Order> {

    private final int ORDER_ID;
    private final int USER_ID;
    private final int USER_STATUS_ID;
    private final int LOGIN;
    private final int NAME;
    private final int SURNAME;
    private final int BIRTH_DATE;
    private final int BANNED;
    private final int CONTACTS_ID;
    private final int EMAIL;
    private final int PHONE_NUMBER;
    private final int COUNTRY;
    private final int CITY;
    private final int STREET;
    private final int HOUSE_NUMBER;
    private final int APARTMENT_NUMBER;
    private final int PAYMENT_METHOD_ID;
    private final int PAYMENT_METHOD_NAME;
    private final int ORDER_STATUS_ID;
    private final int ORDER_STATUS_NAME;
    private final int ORDER_COST;
    private final int ORDER_DATE;


    public OrderRowMapperBuilder(int ORDER_ID, int USER_ID, int USER_STATUS_ID, int LOGIN,
                                 int NAME, int SURNAME, int BIRTH_DATE, int BANNED,
                                 int CONTACTS_ID, int EMAIL, int PHONE_NUMBER, int COUNTRY,
                                 int CITY, int STREET, int HOUSE_NUMBER, int APARTMENT_NUMBER,
                                 int PAYMENT_METHOD_ID, int PAYMENT_METHOD_NAME, int ORDER_STATUS_ID,
                                 int ORDER_STATUS_NAME, int ORDER_COST, int ORDER_DATE) {
        this.ORDER_ID = ORDER_ID;
        this.USER_ID = USER_ID;
        this.USER_STATUS_ID = USER_STATUS_ID;
        this.LOGIN = LOGIN;
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.BIRTH_DATE = BIRTH_DATE;
        this.BANNED = BANNED;
        this.CONTACTS_ID = CONTACTS_ID;
        this.EMAIL = EMAIL;
        this.PHONE_NUMBER = PHONE_NUMBER;
        this.COUNTRY = COUNTRY;
        this.CITY = CITY;
        this.STREET = STREET;
        this.HOUSE_NUMBER = HOUSE_NUMBER;
        this.APARTMENT_NUMBER = APARTMENT_NUMBER;
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
        final User user = getUser(set);
        ////
        return getOrder(set, orderStatus, paymentMethod, user);
    }

    private Order getOrder(ResultSet set,
                           OrderStatus orderStatus,
                           PaymentMethod paymentMethod,
                           User user) throws SQLException {
        final String orderId = set.getString(ORDER_ID);
        final double orderCost = set.getDouble(ORDER_COST);
        final Timestamp orderDate = set.getTimestamp(ORDER_DATE);
        //
        return
                new OrderBuilderImpl(orderId)
                        .withUser(user)
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


    private User getUser(ResultSet set) throws SQLException {
        return
                new UserRowMapperBuilder(USER_ID, USER_STATUS_ID, LOGIN,
                        NAME, SURNAME, BIRTH_DATE,
                        BANNED, CONTACTS_ID, EMAIL,
                        PHONE_NUMBER, COUNTRY, CITY,
                        STREET, HOUSE_NUMBER, APARTMENT_NUMBER)
                        .getBuiltEntity(set);
    }

}
