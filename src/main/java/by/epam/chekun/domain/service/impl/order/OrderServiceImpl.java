package by.epam.chekun.domain.service.impl.order;

import by.epam.chekun.dao.OrderRepository;
import by.epam.chekun.dao.exception.order.OrderDAOException;
import by.epam.chekun.dao.manager.DAOManager;
import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.OrderStatus;
import by.epam.chekun.domain.entity.order.PaymentMethod;
import by.epam.chekun.domain.entity.order.ProductOrder;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.service.BasketService;
import by.epam.chekun.domain.service.OrderService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.basket.BasketServiceException;
import by.epam.chekun.domain.service.exception.order.OrderServiceException;
import by.epam.chekun.domain.service.impl.basket.BasketServiceImpl;
import by.epam.chekun.domain.util.builder.order.impl.OrderBuilderImpl;
import by.epam.chekun.domain.util.builder.order.impl.OrderStatusBuilderImpl;
import by.epam.chekun.domain.util.builder.paymentmethod.impl.PaymentMethodBuilderImpl;
import by.epam.chekun.domain.util.builder.user.impl.UserBuilderImpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static by.epam.chekun.domain.entity.user.UserStatus.ADMIN;
import static by.epam.chekun.domain.entity.user.UserStatus.CUSTOMER;

public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository = DAOManager.getInstance().getOrderRepository();
    private final BasketService basketService = new BasketServiceImpl();

    @Override
    public void add(String userId, String paymentMethodId, String basketId) throws OrderServiceException {

        try {

            final Timestamp orderDate = getOrderTime();
            final double cost = getOrderCost(userId);
            //
            final User user = new UserBuilderImpl(userId).build();
            //
            final PaymentMethod paymentMethod = new PaymentMethodBuilderImpl(paymentMethodId).build();
            //
            String openStatus = "1";
            final OrderStatus orderStatus = new OrderStatusBuilderImpl(openStatus).build();
            //
            final Order order = new OrderBuilderImpl()
                    .withUser(user)
                    .withPaymentMethod(paymentMethod)
                    .withOrderStatus(orderStatus)
                    .withCost(cost)
                    .withOrderDate(orderDate)
                    .build();
            //

            orderRepository.add(order);
            //
            basketService.clearBasket(basketId);
        } catch (OrderDAOException | BasketServiceException e) {
            throw new OrderServiceException(e);
        }
    }

    private double getOrderCost(String userId) throws BasketServiceException {
        return basketService.getCostOfProductsInBasket(userId);
    }

    private Timestamp getOrderTime() {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        final Date now = new Date();
        final String strDate = sdf.format(now);
        return Timestamp.valueOf(strDate);
    }


    @Override
    public List<Order> getAllUserOrdersByUserId(String userId) throws OrderServiceException {
        if (userId == null) {
            throw new OrderServiceException("User id is not valid!");
        }

        try {
            List<Order> orders = orderRepository.getAllOrdersByUserId(userId);
            return orders;
        } catch (OrderDAOException e) {
            throw new OrderServiceException(e);
        }

    }

    @Override
    public List<ProductOrder> getAllProductsFromOrder(String orderId) throws OrderServiceException {
        if (orderId == null) {
            throw new OrderServiceException("order id is not valid!");
        }

        try {
            List<ProductOrder> productsFromOrder = orderRepository.getAllProductsFromOrder(orderId);
            return productsFromOrder;
        } catch (OrderDAOException e) {
            throw new OrderServiceException(e);
        }
    }


    @Override
    public void updateOrderStatus(String orderId, String currentOrderStatusId) throws OrderServiceException {

        final String orderStatusId = getOrderStatusId(currentOrderStatusId);
        try {
            orderRepository.updateOrderStatus(orderId, orderStatusId);
        } catch (OrderDAOException e) {
            throw new OrderServiceException(e);
        }
    }

    private String getOrderStatusId(String currentOrderStatusId) {
        final String open = "1";
        final String close = "2";

        return currentOrderStatusId.equals(open) ? close : open;
    }

    @Override
    public Order getOrderById(String orderId) throws OrderServiceException {
        try {
            return orderRepository.getEntityById(orderId);
        } catch (OrderDAOException e) {
            throw new OrderServiceException(e);
        }
    }
}

