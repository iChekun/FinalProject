package by.epam.chekun.dao.exception.brand;

import by.epam.chekun.dao.exception.DAOException;

public class BrandDAOException extends DAOException {

    public BrandDAOException() {
        super();
    }

    public BrandDAOException(String message) {
        super(message);
    }

    public BrandDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public BrandDAOException(Throwable cause) {
        super(cause);
    }
}
