package by.epam.chekun.domain.util.validator.user.impl;

import by.epam.chekun.domain.util.validator.user.AddressValidator;
import by.epam.chekun.domain.util.validator.user.ContactsValidator;

public class ContactsValidatorImpl implements ContactsValidator {

    private final AddressValidator addressValidator = new AddressValidatorImpl();

    private static final String EMAIL_FORMAT_REGEX =
            "[a-z][[a-z][0-9][-][_]]{3,15}[@][a-z]{2,10}[.][a-z]{2,4}";

    private static final String PHONE_NUMBER_REGEX = "^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$";

    @Override
    public boolean validate(String email, String phoneNumber,
                            String country, String city, String street, int houseNumber, int apartmentNumber) {
        return email.matches(EMAIL_FORMAT_REGEX)
                && phoneNumber.matches(PHONE_NUMBER_REGEX)
                && addressValidator.validate(country, city, street, houseNumber, apartmentNumber);
    }
}
