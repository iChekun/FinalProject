package by.epam.chekun.domain.service.exception.product;

import by.epam.chekun.domain.service.exception.ServiceException;

public class ProductServiceException extends ServiceException {

    public ProductServiceException() {
        super();
    }

    public ProductServiceException(String message) {
        super(message);
    }

    public ProductServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductServiceException(Throwable cause) {
        super(cause);
    }
}
