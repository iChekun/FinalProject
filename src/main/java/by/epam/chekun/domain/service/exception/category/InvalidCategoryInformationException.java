package by.epam.chekun.domain.service.exception.category;

public class InvalidCategoryInformationException extends CategoryServiceException {
    public InvalidCategoryInformationException() {
        super();
    }

    public InvalidCategoryInformationException(String message) {
        super(message);
    }

    public InvalidCategoryInformationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCategoryInformationException(Throwable cause) {
        super(cause);
    }
}
