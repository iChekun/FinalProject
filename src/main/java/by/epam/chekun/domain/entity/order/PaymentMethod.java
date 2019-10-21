package by.epam.chekun.domain.entity.order;

import java.io.Serializable;
import java.util.Objects;

public class PaymentMethod implements Serializable {

    private String paymentMethodId;
    private String name;

    public PaymentMethod() {
    }

    public PaymentMethod(String paymentMethodId, String name) {
        this.paymentMethodId = paymentMethodId;
        this.name = name;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public String getName() {
        return name;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethod that = (PaymentMethod) o;
        return Objects.equals(paymentMethodId, that.paymentMethodId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentMethodId, name);
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "paymentMethodId='" + paymentMethodId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
