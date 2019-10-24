package by.epam.chekun.dao.mapper;

import by.epam.chekun.dao.core.RowMapper;
import by.epam.chekun.dao.mapper.builder.impl.OrderRowMapperBuilder;
import by.epam.chekun.dao.mapper.builder.impl.ProductRowMapperBuilder;
import by.epam.chekun.dao.mapper.builder.impl.UserRowMapperBuilder;
import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.ProductOrder;
import by.epam.chekun.domain.entity.product.Product;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.util.builder.order.impl.ProductOrderBuilderImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductOrderRowMapper implements RowMapper<ProductOrder> {
    //order
    private static final int ORDER_ID = 1;
    //payment_method
    private static final int PAYMENT_METHOD_ID = 2;
    private static final int PAYMENT_METHOD_NAME = 3;
    //order_status
    private static final int ORDER_STATUS_ID = 4;
    private static final int ORDER_STATUS_NAME = 5;
    //
    private static final int ORDER_COST = 6;
    private static final int ORDER_DATE = 7;
    //product
    private static final int PRODUCT_ID = 8;
    private static final int PRODUCT_NAME = 9;
    private static final int PRODUCT_DESCRIPTION = 10;
    private static final int PRODUCT_IMAGE_PATH = 11;
    private static final int PRODUCT_COST = 12;
    //brand
    private static final int BRAND_ID = 13;
    private static final int BRAND_NAME = 14;
    private static final int BRAND_DESCRIPTION = 15;
    private static final int BRAND_IMAGE_PATH = 16;
    //category
    private static final int CATEGORY_ID = 17;
    private static final int CATEGORY_NAME = 18;
    private static final int CATEGORY_DESCRIPTION = 19;
    private static final int CATEGORY_IMAGE_PATH = 20;
    ////////////////////

    private Order order;

    /**
     * In this method order will be equals for all products, because here
     * we get products from order.
     * By this way we make order object one time and after place in all
     * productOrder reference on this object.
     */
    @Override
    public ProductOrder mapRow(ResultSet set) throws SQLException {
        //
        if (this.order == null) { this.order = getOrder(set); }
        //
        final Product product = getProduct(set);
        //
        return getProductOrder(product);
    }

    private Product getProduct(ResultSet set) throws SQLException {
        return
                new ProductRowMapperBuilder(
                        PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION,
                        PRODUCT_IMAGE_PATH, PRODUCT_COST, BRAND_ID,
                        BRAND_NAME, BRAND_DESCRIPTION, BRAND_IMAGE_PATH,
                        CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION,
                        CATEGORY_IMAGE_PATH)
                        .getBuiltEntity(set);
    }

    private ProductOrder getProductOrder(Product product) {
        return
                new ProductOrderBuilderImpl()
                        .withOrder(order)
                        .withProduct(product)
                        .build();
    }

    private Order getOrder(ResultSet set) throws SQLException {
        return
                new OrderRowMapperBuilder(
                        ORDER_ID, PAYMENT_METHOD_ID,
                        PAYMENT_METHOD_NAME, ORDER_STATUS_ID,
                        ORDER_STATUS_NAME, ORDER_COST, ORDER_DATE)
                         .getBuiltEntity(set);
    }

}
