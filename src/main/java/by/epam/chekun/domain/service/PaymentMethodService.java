package by.epam.chekun.domain.service;

import by.epam.chekun.domain.entity.order.PaymentMethod;
import by.epam.chekun.domain.service.exception.paymentmethod.PaymentMethodServiceException;

import java.util.List;

public interface PaymentMethodService {

    void addNewPaymentMethod(String name) throws PaymentMethodServiceException;

    List<PaymentMethod> getAll() throws PaymentMethodServiceException;

    void deletePaymentMethod(String paymentMethodId) throws PaymentMethodServiceException;
}
