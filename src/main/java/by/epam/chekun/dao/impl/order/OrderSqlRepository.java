package by.epam.chekun.dao.impl.order;

import by.epam.chekun.dao.InitializerRepository;
import by.epam.chekun.dao.OrderRepository;
import by.epam.chekun.dao.core.RowMapper;
import by.epam.chekun.dao.core.exception.JdbcTemplateException;
import by.epam.chekun.dao.exception.order.OrderDAOException;
import by.epam.chekun.dao.mapper.OrderRowMapper;
import by.epam.chekun.dao.mapper.ProductOrderRowMapper;
import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.ProductOrder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static by.epam.chekun.dao.impl.order.OrderSqlUtil.*;

public class OrderSqlRepository extends InitializerRepository implements OrderRepository {


    @Override
    public Order getEntityById(String id) throws OrderDAOException {
        try {
            return jdbcTemplate.queryForObject(GET_ORDER_BY_ID, new OrderRowMapper(), id);
        } catch (JdbcTemplateException e) {
            throw new OrderDAOException(e);
        }
    }

    @Override
    public boolean removeById(String id) throws OrderDAOException {
        return false;
    }

    @Override
    public boolean add(Order order) throws OrderDAOException {
        //1 получить id заказа
        //2 добавить сам заказ
        //3 перекинуть все продукты из корзины в заказ
        //4 отчистить корзину уже в сервисе я думаю
        try {
            //
            final String orderId = getOrderId();
            //
            jdbcTemplate.update(ADD_NEW_ORDER,
                    orderId,
                    order.getUser().getUserId(),
                    order.getPaymentMethod().getPaymentMethodId(),
                    order.getOrderStatus().getOrderStatusId(),
                    order.getCost(),
                    order.getOrderDate());

            //
            jdbcTemplate.update(
                    ADD_PRODUCTS_TO_ORDER,
                    orderId,
                    order.getUser().getUserId());
            //
            return true;
        } catch (JdbcTemplateException e) {
            throw new OrderDAOException(e);
        }

    }

    private String getOrderId() throws JdbcTemplateException {

        return jdbcTemplate.queryForObject(GET_UUID_FOR_ORDER,
                new RowMapper<String>() {
                    @Override
                    public String mapRow(ResultSet set) throws SQLException {
                        return set.getString(1);
                    }
                }
                , (Object[]) null);
    }

    @Override
    public boolean update(Order order) throws OrderDAOException {
        return false;
    }

    @Override
    public List<Order> getAll() throws OrderDAOException {
        try {
            final List<Order> orders = jdbcTemplate.query(GET_ALL_ORDERS,
                    new OrderRowMapper());
            return orders;
        } catch (JdbcTemplateException e) {
            throw new OrderDAOException(e);
        }

    }

    @Override
    public List<Order> getAllOrdersByUserId(String userId) throws OrderDAOException {
        try {
            final List<Order> orders = jdbcTemplate.query(GET_ALL_ORDERS_BY_USER_ID,
                    new OrderRowMapper(), userId);
            return orders;
        } catch (JdbcTemplateException e) {
            throw new OrderDAOException(e);
        }
    }

    @Override
    public List<ProductOrder> getAllProductsFromOrder(String orderId) throws OrderDAOException {
        try {
            final List<ProductOrder> productOrders = jdbcTemplate.query(GET_ALL_PRODUCT_FROM_ORDER,
                    new ProductOrderRowMapper(), orderId);
            return productOrders;
        } catch (JdbcTemplateException e) {
            throw new OrderDAOException(e);
        }
    }


    @Override
    public boolean updateOrderStatus(String orderId, String orderStatusId) throws OrderDAOException {
        try {
            jdbcTemplate.update(UPDATE_ORDER_STATUS, orderStatusId, orderId);
            return true;
        } catch (JdbcTemplateException e) {
            throw new OrderDAOException(e);
        }
    }
}
