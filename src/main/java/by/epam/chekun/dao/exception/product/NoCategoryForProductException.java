package by.epam.chekun.dao.exception.product;

public class NoCategoryForProductException extends ProductCategoryDAOException {
    public NoCategoryForProductException() {
        super();
    }

    public NoCategoryForProductException(String message) {
        super(message);
    }

    public NoCategoryForProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoCategoryForProductException(Throwable cause) {
        super(cause);
    }
}
