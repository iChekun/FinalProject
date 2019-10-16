package by.epam.chekun.domain.util.builder.order;

import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.ProductOrder;
import by.epam.chekun.domain.entity.product.Product;

public interface ProductOrderBuilder {

    ProductOrderBuilder withOrder(Order order);

    ProductOrderBuilder withProduct(Product product);

    ProductOrder build();
}
