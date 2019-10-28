package by.epam.chekun.dao.mapper;

import by.epam.chekun.dao.core.RowMapper;
import by.epam.chekun.dao.mapper.builder.impl.OrderRowMapperBuilder;
import by.epam.chekun.dao.mapper.builder.impl.ProductRowMapperBuilder;
import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.ProductOrder;
import by.epam.chekun.domain.entity.product.Product;
import by.epam.chekun.domain.util.builder.order.impl.ProductOrderBuilderImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductOrderRowMapper implements RowMapper<ProductOrder> {
    //order
    private static final int ORDER_ID = 1;
    //user
    private static final int USER_ID = 2;
    private static final int USER_STATUS_ID = 3;
    private static final int LOGIN = 4;
    private static final int NAME = 5;
    private static final int SURNAME = 6;
    private static final int BIRTH_DATE = 7;
    private static final int BANNED = 8;
    private static final int CONTACTS_ID = 9;
    private static final int EMAIL = 10;
    private static final int PHONE_NUMBER = 11;
    private static final int COUNTRY = 12;
    private static final int CITY = 13;
    private static final int STREET = 14;
    private static final int HOUSE_NUMBER = 15;
    private static final int APARTMENT_NUMBER = 16;
    //payment_method
    private static final int PAYMENT_METHOD_ID = 17;
    private static final int PAYMENT_METHOD_NAME = 18;
    //order_status
    private static final int ORDER_STATUS_ID = 19;
    private static final int ORDER_STATUS_NAME = 20;
    //
    private static final int ORDER_COST = 21;
    private static final int ORDER_DATE = 22;
    //product
    private static final int PRODUCT_ID = 23;
    private static final int PRODUCT_NAME = 24;
    private static final int PRODUCT_DESCRIPTION = 25;
    private static final int PRODUCT_IMAGE_PATH = 26;
    private static final int PRODUCT_COST = 27;
    //brand
    private static final int BRAND_ID = 28;
    private static final int BRAND_NAME = 29;
    private static final int BRAND_DESCRIPTION = 30;
    private static final int BRAND_IMAGE_PATH = 31;
    //category
    private static final int CATEGORY_ID = 32;
    private static final int CATEGORY_NAME = 33;
    private static final int CATEGORY_DESCRIPTION = 34;
    private static final int CATEGORY_IMAGE_PATH = 35;
    ////////////////////


    @Override
    public ProductOrder mapRow(ResultSet set) throws SQLException {
        //
        final Order order = getOrder(set);

        //
        final Product product = getProduct(set);
        //
        return getProductOrder(order, product);
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

    private ProductOrder getProductOrder(Order order, Product product) {
        return
                new ProductOrderBuilderImpl()
                        .withOrder(order)
                        .withProduct(product)
                        .build();
    }

    private Order getOrder(ResultSet set) throws SQLException {
        return
                new OrderRowMapperBuilder(
                        ORDER_ID,
                        USER_ID, USER_STATUS_ID, LOGIN,
                        NAME, SURNAME, BIRTH_DATE,
                        BANNED, CONTACTS_ID, EMAIL,
                        PHONE_NUMBER, COUNTRY, CITY,
                        STREET, HOUSE_NUMBER, APARTMENT_NUMBER,
                        PAYMENT_METHOD_ID,
                        PAYMENT_METHOD_NAME, ORDER_STATUS_ID,
                        ORDER_STATUS_NAME, ORDER_COST, ORDER_DATE)
                        .getBuiltEntity(set);
    }

}
