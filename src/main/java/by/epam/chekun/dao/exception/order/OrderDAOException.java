package by.epam.chekun.dao.exception.order;

import by.epam.chekun.dao.exception.DAOException;

public class OrderDAOException extends DAOException {

    public OrderDAOException() {
        super();
    }

    public OrderDAOException(String message) {
        super(message);
    }

    public OrderDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderDAOException(Throwable cause) {
        super(cause);
    }
}
