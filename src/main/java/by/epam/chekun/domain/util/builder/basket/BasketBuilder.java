package by.epam.chekun.domain.util.builder.basket;

import by.epam.chekun.domain.entity.basket.Basket;

public interface BasketBuilder {

    BasketBuilder withUserId(String userId);

    Basket build();
}
