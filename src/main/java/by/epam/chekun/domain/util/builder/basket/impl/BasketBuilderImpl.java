package by.epam.chekun.domain.util.builder.basket.impl;

import by.epam.chekun.domain.entity.basket.Basket;
import by.epam.chekun.domain.util.builder.basket.BasketBuilder;

public class BasketBuilderImpl implements BasketBuilder {

    private String basketId;
    private String userId;

    public BasketBuilderImpl() {
        this.basketId = "";
    }

    public BasketBuilderImpl(String basketId) {
        this.basketId = basketId;
    }


    @Override
    public BasketBuilder withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public Basket build() {
        final Basket basket = new Basket();
        basket.setBasketId(basketId);
        basket.setUserId(userId);
        return basket;
    }

    public String getBasketId() {
        return basketId;
    }

    public String getUserId() {
        return userId;
    }
}
