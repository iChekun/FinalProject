package by.epam.chekun.dao.mapper;


import by.epam.chekun.dao.core.RowMapper;
import by.epam.chekun.dao.mapper.builder.impl.BrandRowMapperBuilder;
import by.epam.chekun.domain.entity.brand.Brand;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRowMapper implements RowMapper<Brand> {

    private static final int BRAND_ID = 1;
    private static final int BRAND_NAME = 2;
    private static final int BRAND_DESCRIPTION = 3;
    private static final int BRAND_IMAGE_PATH = 4;


    @Override
    public Brand mapRow(final ResultSet set) throws SQLException {
        return
                new BrandRowMapperBuilder(
                        BRAND_ID, BRAND_NAME,
                        BRAND_DESCRIPTION, BRAND_IMAGE_PATH)
                        .getBuiltEntity(set);
    }
}
