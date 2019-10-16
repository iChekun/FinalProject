package by.epam.chekun.dao.mapper;

import by.epam.chekun.dao.core.RowMapper;
import by.epam.chekun.dao.mapper.builder.impl.OrderRowMapperBuilder;
import by.epam.chekun.domain.entity.order.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {

    //order
    private static final int ORDER_ID = 1;
    //
    private static final int USER_ID = 2;
    //payment_method
    private static final int PAYMENT_METHOD_ID = 3;
    private static final int PAYMENT_METHOD_NAME = 4;
    //order_status
    private static final int ORDER_STATUS_ID = 5;
    private static final int ORDER_STATUS_NAME = 6;
    //
    private static final int ORDER_COST = 7;
    private static final int ORDER_DATE = 8;


    @Override
    public Order mapRow(ResultSet set) throws SQLException {
        return
                new OrderRowMapperBuilder(
                        ORDER_ID, PAYMENT_METHOD_ID,
                        PAYMENT_METHOD_NAME, ORDER_STATUS_ID,
                        ORDER_STATUS_NAME, ORDER_COST, ORDER_DATE)
                        .getBuiltEntity(set);
    }
}
