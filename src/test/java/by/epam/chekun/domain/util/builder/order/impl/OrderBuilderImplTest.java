package by.epam.chekun.domain.util.builder.order.impl;

import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.OrderStatus;
import by.epam.chekun.domain.entity.order.PaymentMethod;
import by.epam.chekun.domain.entity.user.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Timestamp;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.*;

public class OrderBuilderImplTest {

    private OrderBuilderImpl builder = new OrderBuilderImpl();
    private OrderBuilderImpl readyBuilder = new OrderBuilderImpl("id");

    private User user = mock(User.class);
    private OrderStatus orderStatus = mock(OrderStatus.class);
    private PaymentMethod paymentMethod = mock(PaymentMethod.class);

    @BeforeClass
    public void init() {
        readyBuilder.withUser(user)
                .withCost(1000)
                .withOrderStatus(orderStatus)
                .withPaymentMethod(paymentMethod)
                .withOrderDate(new Timestamp(1000000000));
    }

    @Test
    public void testWithUser() {
        builder.withUser(user);
        assertEquals(builder.getUser(), readyBuilder.getUser());
    }

    @Test
    public void testWithPaymentMethod() {
        builder.withPaymentMethod(paymentMethod);
        assertEquals(builder.getPaymentMethod(), readyBuilder.getPaymentMethod());
    }

    @Test
    public void testWithOrderDate() {
        builder.withOrderDate(new Timestamp(1000000000));
        assertEquals(builder.getOrderDate(), readyBuilder.getOrderDate());
    }

    @Test
    public void testWithCost() {
        builder.withCost(1000);
        assertEquals(builder.getCost(), readyBuilder.getCost());
    }

    @Test
    public void testWithOrderStatus() {
        builder.withOrderStatus(orderStatus);
        assertEquals(builder.getOrderStatus(), readyBuilder.getOrderStatus());
    }

    @Test
    public void testBuild() {
        Order order = new Order();
        order.setCost(1000);
        order.setOrderDate(new Timestamp(1000000000));
        order.setOrderId("id");
        order.setUser(user);
        order.setPaymentMethod(paymentMethod);
        order.setOrderStatus(orderStatus);


        Order result = readyBuilder.build();

        assertEquals(result, order);
    }
}