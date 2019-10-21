package by.epam.chekun.domain.util.builder.order.impl;

import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.ProductOrder;
import by.epam.chekun.domain.entity.product.Product;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.*;

public class ProductOrderBuilderImplTest {


    private ProductOrderBuilderImpl builder = new ProductOrderBuilderImpl();
    private ProductOrderBuilderImpl readyBuilder = new ProductOrderBuilderImpl();

    private Product product = mock(Product.class);
    private Order order = mock(Order.class);

    @BeforeClass
    public void init() {
        readyBuilder.withOrder(order)
                .withProduct(product);
    }

    @Test
    public void testWithOrder() {
        builder.withOrder(order);

        assertEquals(builder.getOrder(), readyBuilder.getOrder());
    }

    @Test
    public void testWithProduct() {
        builder.withProduct(product);

        assertEquals(builder.getProduct(), readyBuilder.getProduct());
    }

    @Test
    public void testBuild() {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setOrder(order);
        productOrder.setProduct(product);

        ProductOrder result = readyBuilder.build();

        assertEquals(result, productOrder);
    }
}