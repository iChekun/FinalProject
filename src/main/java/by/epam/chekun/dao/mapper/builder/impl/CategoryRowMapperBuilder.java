package by.epam.chekun.dao.mapper.builder.impl;

import by.epam.chekun.dao.mapper.builder.RowMapperBuilder;
import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.util.builder.category.impl.CategoryBuilderImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapperBuilder implements RowMapperBuilder<Category> {
    private final int CATEGORY_ID;
    private final int CATEGORY_NAME;
    private final int CATEGORY_DESCRIPTION;
    private final int CATEGORY_IMAGE_PATH;

    public CategoryRowMapperBuilder(int CATEGORY_ID, int CATEGORY_NAME,
                                    int CATEGORY_DESCRIPTION, int CATEGORY_IMAGE_PATH) {
        this.CATEGORY_ID = CATEGORY_ID;
        this.CATEGORY_NAME = CATEGORY_NAME;
        this.CATEGORY_DESCRIPTION = CATEGORY_DESCRIPTION;
        this.CATEGORY_IMAGE_PATH = CATEGORY_IMAGE_PATH;
    }

    @Override
    public Category getBuiltEntity(ResultSet set) throws SQLException {
        return buildCategory(set);
    }


    private Category buildCategory(final ResultSet set) throws SQLException {
        final String categoryId = set.getString(CATEGORY_ID);
        final String name = set.getString(CATEGORY_NAME);
        final String description = set.getString(CATEGORY_DESCRIPTION);
        final String imagePath = set.getString(CATEGORY_IMAGE_PATH);

        //////////////////////////////////////////////////////
        return getCategory(categoryId, name, description, imagePath);
    }

    private Category getCategory(String categoryId, String name, String description, String imagePath) {
        return new CategoryBuilderImpl(categoryId)
                .withName(name)
                .withDescription(description)
                .withImagePath(imagePath)
                .build();
    }
}
