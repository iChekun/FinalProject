package by.epam.chekun.domain.service;

import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.ProductOrder;
import by.epam.chekun.domain.service.exception.ServiceException;

import java.util.List;

public interface OrderService {

    void add(String userId, String paymentMethodId, String basketId) throws ServiceException;

    List<Order> getAllUserOrdersByUserId(String userId) throws ServiceException;

    List<ProductOrder> getAllProductsFromOrder(String orderId) throws ServiceException;

}
