package by.epam.chekun.domain.entity.order;

import by.epam.chekun.domain.entity.user.User;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Order implements Serializable {

    private String orderId;
    private User user;
    private PaymentMethod paymentMethod;
    private Timestamp orderDate;
    private double cost;
    private OrderStatus orderStatus;


    public Order() {
    }

    public Order(String orderId, User user, PaymentMethod paymentMethod, OrderStatus orderStatus,
                 Timestamp orderDate, double cost) {
        this.orderId = orderId;
        this.user = user;
        this.paymentMethod = paymentMethod;
        this.orderDate = orderDate;
        this.cost = cost;
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public double getCost() {
        return cost;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.cost, cost) == 0 &&
                Objects.equals(orderId, order.orderId) &&
                Objects.equals(user, order.user) &&
                Objects.equals(paymentMethod, order.paymentMethod) &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(orderStatus, order.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, user, paymentMethod, orderDate, cost, orderStatus);
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "orderId='" + orderId + '\'' +
                ", user=" + user +
                ", paymentMethod=" + paymentMethod +
                ", orderDate=" + orderDate +
                ", cost=" + cost +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
