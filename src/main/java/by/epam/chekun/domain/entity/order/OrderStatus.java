package by.epam.chekun.domain.entity.order;

import java.io.Serializable;
import java.util.Objects;

public class OrderStatus implements Serializable {
    private String orderStatusId;
    private String name;

    public OrderStatus() {
    }

    public OrderStatus(String orderStatusId, String name) {
        this.orderStatusId = orderStatusId;
        this.name = name;
    }

    public String getOrderStatusId() {
        return orderStatusId;
    }

    public String getName() {
        return name;
    }

    public void setOrderStatusId(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatus that = (OrderStatus) o;
        return Objects.equals(orderStatusId, that.orderStatusId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderStatusId, name);
    }
}
