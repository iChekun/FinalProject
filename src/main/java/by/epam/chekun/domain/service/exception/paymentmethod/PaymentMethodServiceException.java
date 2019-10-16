package by.epam.chekun.domain.service.exception.paymentmethod;

import by.epam.chekun.domain.service.exception.ServiceException;

public class PaymentMethodServiceException extends ServiceException {

    public PaymentMethodServiceException() {
        super();
    }

    public PaymentMethodServiceException(String message) {
        super(message);
    }

    public PaymentMethodServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentMethodServiceException(Throwable cause) {
        super(cause);
    }
}
