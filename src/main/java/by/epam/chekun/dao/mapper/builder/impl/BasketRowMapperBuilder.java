package by.epam.chekun.dao.mapper.builder.impl;

import by.epam.chekun.dao.mapper.builder.RowMapperBuilder;
import by.epam.chekun.domain.entity.basket.Basket;
import by.epam.chekun.domain.util.builder.basket.impl.BasketBuilderImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BasketRowMapperBuilder implements RowMapperBuilder<Basket> {
    private final int BASKET_ID;
    private final int USER_ID;

    public BasketRowMapperBuilder(int BASKET_ID, int USER_ID) {
        this.BASKET_ID = BASKET_ID;
        this.USER_ID = USER_ID;
    }

    @Override
    public Basket getBuiltEntity(ResultSet set) throws SQLException {
        return buildBasket(set);
    }

    private Basket buildBasket(ResultSet set) throws SQLException {
        final String basketId = set.getString(BASKET_ID);
        final String userId = set.getString(USER_ID);
        //
        return getBasket(basketId, userId);
    }

    private Basket getBasket(String basketId, String userId) {
        return
                new BasketBuilderImpl(basketId)
                        .withUserId(userId)
                        .build();
    }
}
