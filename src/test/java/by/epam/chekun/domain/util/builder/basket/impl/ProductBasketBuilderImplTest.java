package by.epam.chekun.domain.util.builder.basket.impl;

import by.epam.chekun.domain.entity.basket.Basket;
import by.epam.chekun.domain.entity.basket.ProductBasket;
import by.epam.chekun.domain.entity.product.Product;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.*;

public class ProductBasketBuilderImplTest {

    private ProductBasketBuilderImpl builder = new ProductBasketBuilderImpl();
    private ProductBasketBuilderImpl readyBuilder = new ProductBasketBuilderImpl();

    private Basket basket = mock(Basket.class);
    private Product product = mock(Product.class);


    @BeforeClass
    public void init() {
        readyBuilder.withBasket(basket)
                .withProduct(product);
    }

    @Test
    public void testWithBasket() {
        builder.withBasket(basket);
        assertEquals(builder.getBasket(), readyBuilder.getBasket());
    }

    @Test
    public void testWithProduct() {
        builder.withProduct(product);
        assertEquals(builder.getProduct(), readyBuilder.getProduct());
    }

    @Test
    public void testBuild() {
        ProductBasket productBasket = new ProductBasket();
        productBasket.setBasket(basket);
        productBasket.setProduct(product);


        ProductBasket result = readyBuilder.build();

        assertEquals(result,productBasket);
    }
}