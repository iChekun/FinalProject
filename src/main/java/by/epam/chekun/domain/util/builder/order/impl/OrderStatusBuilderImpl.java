package by.epam.chekun.domain.util.builder.order.impl;

import by.epam.chekun.domain.entity.order.OrderStatus;
import by.epam.chekun.domain.util.builder.order.OrderStatusBuilder;

public class OrderStatusBuilderImpl implements OrderStatusBuilder {

    private String name;
    private String orderStatusId;

    public OrderStatusBuilderImpl() { }

    public OrderStatusBuilderImpl(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Override
    public OrderStatusBuilder withOrderStatusName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public OrderStatus build() {
        final OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderStatusId(orderStatusId);
        orderStatus.setName(name);
        return orderStatus;
    }

    public String getName() {
        return name;
    }

    public String getOrderStatusId() {
        return orderStatusId;
    }
}
