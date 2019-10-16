package by.epam.chekun.domain.util.validator.user.impl;

import by.epam.chekun.domain.util.validator.user.AddressValidator;

public class AddressValidatorImpl implements AddressValidator {

    private static final String LINE_FORMAT_REGEX = ".{2,30}";


    @Override
    public boolean validate(String country, String city, String street, int houseNumber, int apartmentNumber) {
        return country.matches(LINE_FORMAT_REGEX)
                && city.matches(LINE_FORMAT_REGEX)
                && street.matches(LINE_FORMAT_REGEX)
                && houseNumber > 0
                && apartmentNumber > 0;
    }
}
