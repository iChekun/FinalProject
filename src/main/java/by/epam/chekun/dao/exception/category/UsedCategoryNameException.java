package by.epam.chekun.dao.exception.category;


public class UsedCategoryNameException extends CategoryDAOException {

    public UsedCategoryNameException() {
        super();
    }

    public UsedCategoryNameException(String message) {
        super(message);
    }

    public UsedCategoryNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsedCategoryNameException(Throwable cause) {
        super(cause);
    }
}
