package by.epam.chekun.dao.exception.basket;

import by.epam.chekun.dao.exception.DAOException;

public class BasketDAOException extends DAOException {

    public BasketDAOException() {
        super();
    }

    public BasketDAOException(String message) {
        super(message);
    }

    public BasketDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public BasketDAOException(Throwable cause) {
        super(cause);
    }
}
