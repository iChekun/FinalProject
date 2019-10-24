package by.epam.chekun.dao.mapper;


import by.epam.chekun.dao.core.RowMapper;
import by.epam.chekun.dao.mapper.builder.impl.CategoryRowMapperBuilder;
import by.epam.chekun.domain.entity.category.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {

    private static final int CATEGORY_ID = 1;
    private static final int CATEGORY_NAME = 2;
    private static final int CATEGORY_DESCRIPTION = 3;
    private static final int CATEGORY_IMAGE_PATH = 4;

    ////////////////////////////////////////////////////////////////////////////

    @Override
    public Category mapRow(ResultSet set) throws SQLException {
        return
                new CategoryRowMapperBuilder(
                        CATEGORY_ID, CATEGORY_NAME,
                        CATEGORY_DESCRIPTION, CATEGORY_IMAGE_PATH)
                        .getBuiltEntity(set);
    }
}
