package by.epam.chekun.domain.util.builder.order;

import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.OrderStatus;
import by.epam.chekun.domain.entity.order.PaymentMethod;
import by.epam.chekun.domain.entity.user.User;

import java.sql.Timestamp;

public interface OrderBuilder {

    OrderBuilder withUser(User user);

    OrderBuilder withPaymentMethod(PaymentMethod paymentMethod);

    OrderBuilder withOrderDate(Timestamp orderDate);

    OrderBuilder withCost(double cost);

    OrderBuilder withOrderStatus(OrderStatus orderStatus);

    Order build();

}
