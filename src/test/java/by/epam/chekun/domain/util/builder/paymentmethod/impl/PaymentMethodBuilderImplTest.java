package by.epam.chekun.domain.util.builder.paymentmethod.impl;

import by.epam.chekun.domain.entity.order.PaymentMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PaymentMethodBuilderImplTest {

    private PaymentMethodBuilderImpl builder = new PaymentMethodBuilderImpl();
    private PaymentMethodBuilderImpl readyBuilder = new PaymentMethodBuilderImpl("id");


    @BeforeClass
    public void init() {
        readyBuilder.withName("name");
    }

    @Test
    public void testWithName() {
        builder.withName("name");

        assertEquals(builder.getName(), readyBuilder.getName());
    }

    @Test
    public void testBuild() {

        PaymentMethod method = new PaymentMethod();
        method.setName("name");
        method.setPaymentMethodId("id");

        PaymentMethod result = readyBuilder.build();

        assertEquals(result, method);
    }
}