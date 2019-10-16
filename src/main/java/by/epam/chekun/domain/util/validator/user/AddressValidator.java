package by.epam.chekun.domain.util.validator.user;

public interface AddressValidator {

    boolean validate(String country, String city, String street,
                     int houseNumber, int apartmentNumber);
}
