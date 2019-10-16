package by.epam.chekun.domain.service.exception.product;

public class InvalidProductInformationException extends ProductServiceException {
    public InvalidProductInformationException() {
        super();
    }

    public InvalidProductInformationException(String message) {
        super(message);
    }

    public InvalidProductInformationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidProductInformationException(Throwable cause) {
        super(cause);
    }
}
