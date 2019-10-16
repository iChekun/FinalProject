package by.epam.chekun.dao.exception.product;

public class NoBrandForProductException extends ProductBrandDAOException {
    public NoBrandForProductException() {
        super();
    }

    public NoBrandForProductException(String message) {
        super(message);
    }

    public NoBrandForProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoBrandForProductException(Throwable cause) {
        super(cause);
    }
}
