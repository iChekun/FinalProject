package by.epam.chekun.domain.util.validator.user;

public interface ContactsValidator {

    boolean validate(String email, String phoneNumber,
                     String country, String city, String street,
                     int houseNumber, int apartmentNumber);
}
