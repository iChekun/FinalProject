package by.epam.chekun.domain.util.builder.product.impl;

import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.entity.product.Product;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;

public class ProductBuilderImplTest {

    private ProductBuilderImpl builder = new ProductBuilderImpl();
    private ProductBuilderImpl readyBuilder = new ProductBuilderImpl("id");

    private Category category = mock(Category.class);
    private Brand brand = mock(Brand.class);

    @BeforeClass
    public void init() {
        readyBuilder.withName("name")
                .withDescription("description")
                .withImagePath("imagePath")
                .withCost(1000)
                .withBrand(brand)
                .withCategory(category);
    }

    @Test
    public void testWithCategory() {
        builder.withCategory(category);
        assertEquals(builder.getCategory(), readyBuilder.getCategory());
    }

    @Test
    public void testWithBrand() {
        builder.withBrand(brand);
        assertEquals(builder.getBrand(), readyBuilder.getBrand());
    }

    @Test
    public void testWithName() {
        builder.withName("name");
        assertEquals(builder.getName(), readyBuilder.getName());
    }

    @Test
    public void testWithDescription() {
        builder.withDescription("description");
        assertEquals(builder.getDescription(), readyBuilder.getDescription());
    }

    @Test
    public void testWithImagePath() {
        builder.withImagePath("imagePath");
        assertEquals(builder.getImagePath(), readyBuilder.getImagePath());
    }

    @Test
    public void testWithCost() {
        builder.withCost(1000);
        assertEquals(builder.getCost(), readyBuilder.getCost());
    }

    @Test
    public void testBuild() {
        Product product = new Product();
        product.setProductId("id");
        product.setName("name");
        product.setDescription("description");
        product.setImagePath("imagePath");
        product.setCost(1000);
        product.setBrand(brand);
        product.setCategory(category);

        Product result = readyBuilder.build();

        assertEquals(product, result);


    }
}