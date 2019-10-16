package by.epam.chekun.domain.service.exception.category;

import by.epam.chekun.domain.service.exception.ServiceException;

public class CategoryServiceException extends ServiceException {

    public CategoryServiceException() {
        super();
    }

    public CategoryServiceException(String message) {
        super(message);
    }

    public CategoryServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryServiceException(Throwable cause) {
        super(cause);
    }
}
