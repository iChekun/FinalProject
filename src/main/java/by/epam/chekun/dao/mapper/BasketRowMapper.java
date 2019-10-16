package by.epam.chekun.dao.mapper;

import by.epam.chekun.dao.core.RowMapper;
import by.epam.chekun.dao.mapper.builder.impl.BasketRowMapperBuilder;
import by.epam.chekun.domain.entity.basket.Basket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BasketRowMapper implements RowMapper<Basket> {


    private static final int BASKET_ID = 1;
    private static final int USER_ID = 2;

    @Override
    public Basket mapRow(ResultSet set) throws SQLException {
        return
                new BasketRowMapperBuilder
                        (BASKET_ID, USER_ID)
                        .getBuiltEntity(set);
    }
}
