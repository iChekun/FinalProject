package by.epam.chekun.domain.util.builder.order;

import by.epam.chekun.domain.entity.order.OrderStatus;

public interface OrderStatusBuilder {
    OrderStatusBuilder withOrderStatusName(String name);

    OrderStatus build();

}
