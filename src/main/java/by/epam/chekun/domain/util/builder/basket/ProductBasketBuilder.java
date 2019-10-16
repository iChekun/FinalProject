package by.epam.chekun.domain.util.builder.basket;

import by.epam.chekun.domain.entity.basket.Basket;
import by.epam.chekun.domain.entity.basket.ProductBasket;
import by.epam.chekun.domain.entity.product.Product;

import java.util.List;

public interface ProductBasketBuilder {

    ProductBasketBuilder withBasket(Basket basket);

    ProductBasketBuilder withProduct(Product product);

    ProductBasket build();
}
