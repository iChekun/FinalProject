package by.epam.chekun.domain.util.builder.order.impl;

import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.ProductOrder;
import by.epam.chekun.domain.entity.product.Product;
import by.epam.chekun.domain.util.builder.order.ProductOrderBuilder;

public class ProductOrderBuilderImpl implements ProductOrderBuilder {

    private Order order;
    private Product product;


    @Override
    public ProductOrderBuilder withOrder(Order order) {
        this.order = order;
        return this;
    }

    @Override
    public ProductOrderBuilder withProduct(Product product) {
        this.product = product;
        return this;
    }

    @Override
    public ProductOrder build() {
        final ProductOrder productOrder = new ProductOrder(order, product);
        return productOrder;
    }
}
