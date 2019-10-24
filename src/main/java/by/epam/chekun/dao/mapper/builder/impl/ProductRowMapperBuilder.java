package by.epam.chekun.dao.mapper.builder.impl;

import by.epam.chekun.dao.mapper.builder.RowMapperBuilder;
import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.entity.product.Product;
import by.epam.chekun.domain.util.builder.product.impl.ProductBuilderImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapperBuilder implements RowMapperBuilder<Product> {

    private final int PRODUCT_ID;
    private final int PRODUCT_NAME;
    private final int PRODUCT_DESCRIPTION;
    private final int PRODUCT_IMAGE_PATH;
    private final int PRODUCT_COST;


    private final int BRAND_ID;
    private final int BRAND_NAME;
    private final int BRAND_DESCRIPTION;
    private final int BRAND_IMAGE_PATH;

    private final int CATEGORY_ID;
    private final int CATEGORY_NAME;
    private final int CATEGORY_DESCRIPTION;
    private final int CATEGORY_IMAGE_PATH;

    public ProductRowMapperBuilder(int PRODUCT_ID, int PRODUCT_NAME, int PRODUCT_DESCRIPTION,
                                   int PRODUCT_IMAGE_PATH, int PRODUCT_COST, int BRAND_ID,
                                   int BRAND_NAME, int BRAND_DESCRIPTION, int BRAND_IMAGE_PATH,
                                   int CATEGORY_ID, int CATEGORY_NAME, int CATEGORY_DESCRIPTION,
                                   int CATEGORY_IMAGE_PATH) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
        this.PRODUCT_IMAGE_PATH = PRODUCT_IMAGE_PATH;
        this.PRODUCT_COST = PRODUCT_COST;
        this.BRAND_ID = BRAND_ID;
        this.BRAND_NAME = BRAND_NAME;
        this.BRAND_DESCRIPTION = BRAND_DESCRIPTION;
        this.BRAND_IMAGE_PATH = BRAND_IMAGE_PATH;
        this.CATEGORY_ID = CATEGORY_ID;
        this.CATEGORY_NAME = CATEGORY_NAME;
        this.CATEGORY_DESCRIPTION = CATEGORY_DESCRIPTION;
        this.CATEGORY_IMAGE_PATH = CATEGORY_IMAGE_PATH;
    }


    @Override
    public Product getBuiltEntity(ResultSet set) throws SQLException {
        return buildProduct(set);
    }


    private Product buildProduct(final ResultSet set) throws SQLException {
        final Brand brand = getBrand(set);
        /////////////////////////////////////////////////////
        final Category category = getCategory(set);
        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        return getProduct(set, brand, category);
    }

    private Product getProduct(final ResultSet set,
                               final Brand brand,
                               final Category category) throws SQLException {
        final String productId = set.getString(PRODUCT_ID);
        final String productName = set.getString(PRODUCT_NAME);
        final String productDescription = set.getString(PRODUCT_DESCRIPTION);
        final String productImagePath = set.getString(PRODUCT_IMAGE_PATH);
        final double productCost = set.getDouble(PRODUCT_COST);

        return getProduct(brand, category, productId,
                productName, productDescription, productImagePath, productCost);
    }

    private Product getProduct(Brand brand, Category category, String productId, String productName,
                               String productDescription, String productImagePath, double productCost) {
        return
                new ProductBuilderImpl(productId)
                        .withName(productName)
                        .withDescription(productDescription)
                        .withImagePath(productImagePath)
                        .withCost(productCost)
                        .withCategory(category)
                        .withBrand(brand)
                        .build();
    }

    private Category getCategory(ResultSet set) throws SQLException {
        return
                new CategoryRowMapperBuilder(
                        CATEGORY_ID, CATEGORY_NAME,
                        CATEGORY_DESCRIPTION, CATEGORY_IMAGE_PATH)
                        .getBuiltEntity(set);

    }


    private Brand getBrand(ResultSet set) throws SQLException {
        return
                new BrandRowMapperBuilder(
                        BRAND_ID, BRAND_NAME,
                        BRAND_DESCRIPTION, BRAND_IMAGE_PATH)
                        .getBuiltEntity(set);
    }

}
