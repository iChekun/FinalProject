package by.epam.chekun.domain.util.builder.paymentmethod;

import by.epam.chekun.domain.entity.order.PaymentMethod;

public interface PaymentMethodBuilder {

    PaymentMethodBuilder withName(String name);

    PaymentMethod build();
}
