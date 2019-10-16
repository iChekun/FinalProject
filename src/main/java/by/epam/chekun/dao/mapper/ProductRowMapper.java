package by.epam.chekun.dao.mapper;

import by.epam.chekun.dao.core.RowMapper;
import by.epam.chekun.dao.mapper.builder.impl.ProductRowMapperBuilder;
import by.epam.chekun.domain.entity.product.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    private static final int PRODUCT_ID = 1;
    private static final int PRODUCT_NAME = 2;
    private static final int PRODUCT_DESCRIPTION = 3;
    private static final int PRODUCT_IMAGE_PATH = 4;
    private static final int PRODUCT_COST = 5;


    private static final int BRAND_ID = 6;
    private static final int BRAND_NAME = 7;
    private static final int BRAND_DESCRIPTION = 8;
    private static final int BRAND_IMAGE_PATH = 9;

    private static final int CATEGORY_ID = 10;
    private static final int CATEGORY_NAME = 11;
    private static final int CATEGORY_DESCRIPTION = 12;
    private static final int CATEGORY_IMAGE_PATH = 13;


    @Override
    public Product mapRow(ResultSet set) throws SQLException {
        /////////////////////////////////////////////////////
        return
                new ProductRowMapperBuilder(
                        PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION,
                        PRODUCT_IMAGE_PATH, PRODUCT_COST, BRAND_ID,
                        BRAND_NAME, BRAND_DESCRIPTION, BRAND_IMAGE_PATH,
                        CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION,
                        CATEGORY_IMAGE_PATH)
                        .getBuiltEntity(set);
    }

}
