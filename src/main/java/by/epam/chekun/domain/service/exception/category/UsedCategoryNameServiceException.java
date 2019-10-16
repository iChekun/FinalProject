package by.epam.chekun.domain.service.exception.category;

public class UsedCategoryNameServiceException extends CategoryServiceException {

    public UsedCategoryNameServiceException() {
        super();
    }

    public UsedCategoryNameServiceException(String message) {
        super(message);
    }

    public UsedCategoryNameServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsedCategoryNameServiceException(Throwable cause) {
        super(cause);
    }
}
