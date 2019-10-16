package by.epam.chekun.dao.exception.product;

import by.epam.chekun.dao.exception.DAOException;

public class ProductDAOException extends DAOException {

    public ProductDAOException() {
        super();
    }

    public ProductDAOException(String message) {
        super(message);
    }

    public ProductDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductDAOException(Throwable cause) {
        super(cause);
    }
}
