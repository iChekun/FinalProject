package by.epam.chekun.dao.mapper.builder.impl;

import by.epam.chekun.dao.mapper.builder.RowMapperBuilder;
import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.util.builder.brand.impl.BrandBuilderImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRowMapperBuilder implements RowMapperBuilder<Brand> {

    private final int BRAND_ID;
    private final int BRAND_NAME;
    private final int BRAND_DESCRIPTION;
    private final int BRAND_IMAGE_PATH;

    public BrandRowMapperBuilder(int BRAND_ID, int BRAND_NAME,
                                 int BRAND_DESCRIPTION, int BRAND_IMAGE_PATH) {
        this.BRAND_ID = BRAND_ID;
        this.BRAND_NAME = BRAND_NAME;
        this.BRAND_DESCRIPTION = BRAND_DESCRIPTION;
        this.BRAND_IMAGE_PATH = BRAND_IMAGE_PATH;
    }

    @Override
    public Brand getBuiltEntity(ResultSet set) throws SQLException {
        return buildBrand(set);
    }


    private Brand buildBrand(ResultSet set) throws SQLException {
        final String brandId = set.getString(BRAND_ID);
        final String name = set.getString(BRAND_NAME);
        final String description = set.getString(BRAND_DESCRIPTION);
        final String imagePath = set.getString(BRAND_IMAGE_PATH);
        //////////////////////////////////////////////////////
        return getBrand(brandId, name, description, imagePath);
    }

    private Brand getBrand(String brandId, String name, String description, String imagePath) {
        return
                new BrandBuilderImpl(brandId)
                        .withName(name)
                        .withDescription(description)
                        .withImagePath(imagePath)
                        .build();
    }
}
