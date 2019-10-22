package by.epam.chekun.domain.util.builder.paymentmethod.impl;

import by.epam.chekun.domain.entity.order.PaymentMethod;
import by.epam.chekun.domain.util.builder.paymentmethod.PaymentMethodBuilder;

public class PaymentMethodBuilderImpl implements PaymentMethodBuilder {


    private String paymentMethodId;
    private String name;

    public PaymentMethodBuilderImpl() {
        this.paymentMethodId = "";
    }

    public PaymentMethodBuilderImpl(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @Override
    public PaymentMethodBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PaymentMethod build() {
        final PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setPaymentMethodId(paymentMethodId);
        paymentMethod.setName(name);
        return paymentMethod;
    }


    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public String getName() {
        return name;
    }
}
