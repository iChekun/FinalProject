package by.epam.chekun.domain.service.exception.brand;

import by.epam.chekun.domain.service.exception.ServiceException;

public class BrandServiceException extends ServiceException {

    public BrandServiceException() {
        super();
    }

    public BrandServiceException(String message) {
        super(message);
    }

    public BrandServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BrandServiceException(Throwable cause) {
        super(cause);
    }
}
