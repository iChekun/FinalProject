package by.epam.chekun.dao.exception.paymentmethod;

import by.epam.chekun.dao.exception.DAOException;

public class PaymentMethodDAOException extends DAOException {

    public PaymentMethodDAOException() {
        super();
    }

    public PaymentMethodDAOException(String message) {
        super(message);
    }

    public PaymentMethodDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentMethodDAOException(Throwable cause) {
        super(cause);
    }
}
