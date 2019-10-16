package by.epam.chekun.domain.util.builder.order.impl;

import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.OrderStatus;
import by.epam.chekun.domain.entity.order.PaymentMethod;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.util.builder.order.OrderBuilder;

import java.sql.Timestamp;

public class OrderBuilderImpl implements OrderBuilder {


    private String orderId;
    private OrderStatus orderStatus;

    private User user;
    private PaymentMethod paymentMethod;

    private Timestamp orderDate;

    private double cost;

    public OrderBuilderImpl() {
        this.orderId = "";
    }

    public OrderBuilderImpl(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public OrderBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public OrderBuilder withPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    @Override
    public OrderBuilder withOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    @Override
    public OrderBuilder withCost(double cost) {
        this.cost = cost;
        return this;
    }

    @Override
    public OrderBuilder withOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    @Override
    public Order build() {
        final Order order = new Order(orderId, user, paymentMethod, orderStatus,
                orderDate, cost);
        return order;
    }
}
