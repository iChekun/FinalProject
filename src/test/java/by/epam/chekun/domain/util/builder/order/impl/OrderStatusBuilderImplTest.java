package by.epam.chekun.domain.util.builder.order.impl;

import by.epam.chekun.domain.entity.order.OrderStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OrderStatusBuilderImplTest {

    private OrderStatusBuilderImpl builder = new OrderStatusBuilderImpl();
    private OrderStatusBuilderImpl readyBuilder = new OrderStatusBuilderImpl("id");

    @BeforeClass
    public void init() {
        readyBuilder.withOrderStatusName("name");
    }

    @Test
    public void testWithOrderStatusName() {
        builder.withOrderStatusName("name");

        assertEquals(builder.getName(), readyBuilder.getName());
    }

    @Test
    public void testBuild() {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setName("name");
        orderStatus.setOrderStatusId("id");

        OrderStatus result = readyBuilder.build();

        assertEquals(result, orderStatus);
    }
}