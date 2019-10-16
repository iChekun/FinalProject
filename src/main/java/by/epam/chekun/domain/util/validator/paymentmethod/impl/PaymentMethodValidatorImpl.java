package by.epam.chekun.domain.util.validator.paymentmethod.impl;

import by.epam.chekun.domain.util.validator.paymentmethod.PaymentMethodValidator;

public class PaymentMethodValidatorImpl implements PaymentMethodValidator {

    private static final String NAME_FORMAT_REGEX = ".{2,12}";

    @Override
    public boolean validate(String name) {
        return name.matches(NAME_FORMAT_REGEX);
    }
}