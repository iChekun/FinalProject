package by.epam.chekun.domain.util.builder.basket.impl;

import by.epam.chekun.domain.entity.basket.Basket;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketBuilderImplTest {

    private BasketBuilderImpl builder = new BasketBuilderImpl();
    private BasketBuilderImpl readyBuilder = new BasketBuilderImpl("id");


    @BeforeClass
    public void init() {
        readyBuilder.withUserId("userId");
    }

    @Test
    public void testWithUserId() {
        builder.withUserId("userId");
        assertEquals(builder.getUserId(), readyBuilder.getUserId());
    }

    @Test
    public void testBuild() {
        Basket basket = new Basket();
        basket.setBasketId("id");
        basket.setUserId("userId");

        Basket result = readyBuilder.build();

        assertEquals(result, basket);
    }
}