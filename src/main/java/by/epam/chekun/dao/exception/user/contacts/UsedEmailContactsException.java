package by.epam.chekun.dao.exception.user.contacts;

public class UsedEmailContactsException extends ContactsDAOException {

    public UsedEmailContactsException() {
        super();
    }

    public UsedEmailContactsException(String message) {
        super(message);
    }

    public UsedEmailContactsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsedEmailContactsException(Throwable cause) {
        super(cause);
    }
}
