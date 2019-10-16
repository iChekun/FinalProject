package by.epam.chekun.domain.util.validator.product.impl;

import by.epam.chekun.domain.util.validator.product.ProductValidator;

public class ProductValidatorImpl implements ProductValidator {

    private static final String NAME_FORMAT_REGEX = ".{2,30}";

    private static final String DESCRIPTION_FORMAT_REGEX = ".{0,255}";


    @Override
    public boolean validate(String name, String description, String cost) {
        return name.matches(NAME_FORMAT_REGEX)
                && description.matches(DESCRIPTION_FORMAT_REGEX)
                && isCostCorrect(cost);
    }


    private boolean isCostCorrect(String cost) {
        try {
            double doubleCost = Double.parseDouble(cost);
            return doubleCost > 0;
        } catch (NumberFormatException ignore) {
            return false;
        }
    }
}
