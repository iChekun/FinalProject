package by.epam.chekun.domain.service.exception.paymentmethod;

public class InvalidPaymentMethodInformationException extends PaymentMethodServiceException {
    public InvalidPaymentMethodInformationException() {
        super();
    }

    public InvalidPaymentMethodInformationException(String message) {
        super(message);
    }

    public InvalidPaymentMethodInformationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPaymentMethodInformationException(Throwable cause) {
        super(cause);
    }
}
