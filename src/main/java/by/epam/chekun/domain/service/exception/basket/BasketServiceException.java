package by.epam.chekun.domain.service.exception.basket;

import by.epam.chekun.domain.service.exception.ServiceException;

public class BasketServiceException  extends ServiceException {

    public BasketServiceException() {
        super();
    }

    public BasketServiceException(String message) {
        super(message);
    }

    public BasketServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BasketServiceException(Throwable cause) {
        super(cause);
    }
}
