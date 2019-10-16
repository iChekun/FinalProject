package by.epam.chekun.dao.exception.category;

import by.epam.chekun.dao.exception.DAOException;

public class CategoryDAOException extends DAOException {

    public CategoryDAOException() {
        super();
    }

    public CategoryDAOException(String message) {
        super(message);
    }

    public CategoryDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryDAOException(Throwable cause) {
        super(cause);
    }
}
