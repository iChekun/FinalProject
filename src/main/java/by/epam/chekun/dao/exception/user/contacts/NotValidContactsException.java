package by.epam.chekun.dao.exception.user.contacts;

public class NotValidContactsException extends ContactsDAOException {

    public NotValidContactsException() {
        super();
    }

    public NotValidContactsException(String message) {
        super(message);
    }

    public NotValidContactsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidContactsException(Throwable cause) {
        super(cause);
    }
}
