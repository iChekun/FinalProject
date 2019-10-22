package by.epam.chekun.domain.util.builder.product.impl;

import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.util.builder.category.impl.CategoryBuilderImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CategoryBuilderImplTest {


    private CategoryBuilderImpl builder = new CategoryBuilderImpl();
    private CategoryBuilderImpl readyBuilder = new CategoryBuilderImpl("id");


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
        Category category = new Category();
        category.setCategoryId("id");
        category.setName("name");
        category.setDescription("description");
        category.setImagePath("imagePath");

        Category result = readyBuilder.build();

        assertEquals(result, category);
    }
}