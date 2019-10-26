package by.epam.chekun.domain.service;

import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.ProductOrder;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.order.OrderServiceException;

import java.util.List;

public interface OrderService {

    void add(String userId, String paymentMethodId, String basketId) throws OrderServiceException;

    List<Order> getAllUserOrdersByUserId(String userId) throws OrderServiceException;

    List<ProductOrder> getAllProductsFromOrder(String orderId) throws OrderServiceException;

    void updateOrderStatus(String orderId, String currentOrderStatusId) throws OrderServiceException;

    Order getOrderById(String orderId) throws OrderServiceException;

    void invalidateOrder(String orderId) throws OrderServiceException;
}
