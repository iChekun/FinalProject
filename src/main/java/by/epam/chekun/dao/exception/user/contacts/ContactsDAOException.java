package by.epam.chekun.dao.exception.user.contacts;

import by.epam.chekun.dao.exception.user.UserDAOException;

public class ContactsDAOException extends UserDAOException {

    public ContactsDAOException() {
        super();
    }

    public ContactsDAOException(String message) {
        super(message);
    }

    public ContactsDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactsDAOException(Throwable cause) {
        super(cause);
    }
}
