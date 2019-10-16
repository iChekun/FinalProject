package by.epam.chekun.domain.util.validator.user.impl;

import by.epam.chekun.domain.util.validator.user.ContactsValidator;
import by.epam.chekun.domain.util.validator.user.UserValidator;

import java.sql.Date;

public class UserValidatorImpl implements UserValidator {

    private final ContactsValidator contactsValidator = new ContactsValidatorImpl();

    private static final String LOGIN_FORMAT_REGEX = "^[a-zA-Z][a-zA-Z0-9-_.]{4,13}$";

    private static final String PASSWORD_FORMAT_REGEX = "^[a-zA-Z][a-zA-Z0-9-_.]{6,15}$";

    private static final String NAME_FORMAT_REGEX = ".{2,30}";

    /**
     * Validates given parameters by required formats( checks if login consists of 4-13 symbols
     * and password consists 8-30 symbols).
     *
     * @param login    login to validate
     * @param password password to validate
     * @return {@code true} if given parameters correct
     * {@code false} otherwise.
     */
    public boolean validate(final String login, final String password) {
        return login.matches(LOGIN_FORMAT_REGEX)
                && password.matches(PASSWORD_FORMAT_REGEX);
    }

    @Override
    public boolean validate(String login, String password, String confirmedPassword,
                            String name, String surname, Date birthDate,
                            String email, String phoneNumber,
                            String country, String city, String street,
                            int houseNumber, int apartmentNumber) {
        return password.equals(confirmedPassword)
                && validate(login, password)
                && name.matches(NAME_FORMAT_REGEX)
                && surname.matches(NAME_FORMAT_REGEX)
                && contactsValidator.validate(email, phoneNumber,
                country, city, street, houseNumber, apartmentNumber);
    }

    @Override
    public boolean validate(String login, String name, String surname,
                            Date birthDate, String email, String phoneNumber,
                            String country, String city, String street, int houseNumber, int apartmentNumber) {
        return login.matches(LOGIN_FORMAT_REGEX)
                && name.matches(NAME_FORMAT_REGEX)
                && surname.matches(NAME_FORMAT_REGEX)
                && contactsValidator.validate(email, phoneNumber,
                country, city, street, houseNumber, apartmentNumber);
    }

    @Override
    public boolean validatePassword(String currentPassword, String newPassword, String confirmedPassword) {
        return newPassword.equals(confirmedPassword)
                && currentPassword.matches(PASSWORD_FORMAT_REGEX)
                && newPassword.matches(PASSWORD_FORMAT_REGEX)
                && confirmedPassword.matches(PASSWORD_FORMAT_REGEX);

    }
}
