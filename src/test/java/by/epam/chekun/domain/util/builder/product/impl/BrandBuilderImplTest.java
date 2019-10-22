package by.epam.chekun.domain.util.builder.product.impl;

import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.util.builder.brand.impl.BrandBuilderImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BrandBuilderImplTest {

    private BrandBuilderImpl builder = new BrandBuilderImpl();
    private BrandBuilderImpl readyBuilder = new BrandBuilderImpl("id");


    @BeforeClass
    public void init() {
        readyBuilder.withName("name")
                .withDescription("description")
                .withImagePath("imagePath");
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
    public void testBuild() {
        Brand brand = new Brand();
        brand.setBrandId("id");
        brand.setName("name");
        brand.setDescription("description");
        brand.setImagePath("imagePath");

        Brand result = readyBuilder.build();

        assertEquals(result, brand);
    }
}