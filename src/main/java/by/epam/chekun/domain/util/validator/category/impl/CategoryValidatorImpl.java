package by.epam.chekun.domain.util.validator.category.impl;

import by.epam.chekun.domain.util.validator.category.CategoryValidator;

public class CategoryValidatorImpl implements CategoryValidator {

    private static final String NAME_FORMAT_REGEX = ".{2,30}";

    private static final String DESCRIPTION_FORMAT_REGEX = ".{0,255}";


    @Override
    public boolean validate(String name, String description) {
        return name.matches(NAME_FORMAT_REGEX)
                && description.matches(DESCRIPTION_FORMAT_REGEX);
    }
}
