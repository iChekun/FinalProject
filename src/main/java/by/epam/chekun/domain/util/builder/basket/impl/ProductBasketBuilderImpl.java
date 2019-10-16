package by.epam.chekun.domain.util.builder.basket.impl;

import by.epam.chekun.domain.entity.basket.Basket;
import by.epam.chekun.domain.entity.basket.ProductBasket;
import by.epam.chekun.domain.entity.product.Product;
import by.epam.chekun.domain.util.builder.basket.ProductBasketBuilder;

public class ProductBasketBuilderImpl implements ProductBasketBuilder {

    private Basket basket;
    private Product product;


    @Override
    public ProductBasketBuilder withBasket(Basket basket) {
        this.basket = basket;
        return this;
    }


    @Override
    public ProductBasketBuilder withProduct(Product product) {
        this.product = product;
        return this;
    }

    @Override
    public ProductBasket build() {
        final ProductBasket productBasket = new ProductBasket(basket, product);
        return productBasket;
    }
}
