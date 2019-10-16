package by.epam.chekun.domain.util.validator.user;

import java.sql.Date;

public interface UserValidator {

    boolean validate(final String login, final String password);

    boolean validate(final String login, final String password, final String confirmedPassword,
                     final String name, final String surname, final Date birthDate,
                     final String email, final String phoneNumber,
                     final String country, final String city, final String street,
                     final int houseNumber, final int apartmentNumber);

    boolean validate(final String login,
                     final String name, final String surname, final Date birthDate,
                     final String email, final String phoneNumber,
                     final String country, final String city, final String street,
                     final int houseNumber, final int apartmentNumber);

    boolean validatePassword(String currentPassword, String newPassword, String confirmedPassword);
}

