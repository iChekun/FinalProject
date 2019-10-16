package by.epam.chekun.domain.service.exception.brand;

public class InvalidBrandInformationException extends BrandServiceException {

    public InvalidBrandInformationException() {
        super();
    }

    public InvalidBrandInformationException(String message) {
        super(message);
    }

    public InvalidBrandInformationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBrandInformationException(Throwable cause) {
        super(cause);
    }
}
