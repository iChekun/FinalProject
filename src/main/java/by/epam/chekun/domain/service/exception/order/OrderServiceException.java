package by.epam.chekun.domain.service.exception.order;


import by.epam.chekun.domain.service.exception.ServiceException;

public class OrderServiceException extends ServiceException {


    public OrderServiceException() {
        super();
    }

    public OrderServiceException(String message) {
        super(message);
    }

    public OrderServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderServiceException(Throwable cause) {
        super(cause);
    }
}
