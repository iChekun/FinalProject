package by.epam.chekun.dao.exception.user;

import by.epam.chekun.dao.exception.DAOException;

public class UserDAOException extends DAOException {

    public UserDAOException() {
        super();
    }

    public UserDAOException(String message) {
        super(message);
    }

    public UserDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDAOException(Throwable cause) {
        super(cause);
    }
}
