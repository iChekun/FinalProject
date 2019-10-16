package by.epam.chekun.dao;

import by.epam.chekun.dao.exception.order.OrderDAOException;
import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.ProductOrder;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order> {

    @Override
    Order getEntityById(String id) throws OrderDAOException;

    @Override
    boolean removeById(String id) throws OrderDAOException;

    @Override
    boolean add(Order order) throws OrderDAOException;

    @Override
    boolean update(Order order) throws OrderDAOException;

    @Override
    List<Order> getAll() throws OrderDAOException;


    List<Order> getAllOrdersByUserId(String userId) throws OrderDAOException;

    List<ProductOrder> getAllProductsFromOrder(String orderId) throws OrderDAOException;
}
