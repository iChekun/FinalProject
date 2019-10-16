package by.epam.chekun.domain.util.manager;

import by.epam.chekun.domain.util.hasher.PasswordHashKeeper;
import by.epam.chekun.domain.util.hasher.PasswordHashKeeperImpl;
import by.epam.chekun.domain.util.validator.brand.BrandValidator;
import by.epam.chekun.domain.util.validator.brand.impl.BrandValidatorImpl;
import by.epam.chekun.domain.util.validator.category.CategoryValidator;
import by.epam.chekun.domain.util.validator.category.impl.CategoryValidatorImpl;
import by.epam.chekun.domain.util.validator.paymentmethod.PaymentMethodValidator;
import by.epam.chekun.domain.util.validator.paymentmethod.impl.PaymentMethodValidatorImpl;
import by.epam.chekun.domain.util.validator.product.ProductValidator;
import by.epam.chekun.domain.util.validator.product.impl.ProductValidatorImpl;
import by.epam.chekun.domain.util.validator.user.UserValidator;
import by.epam.chekun.domain.util.validator.user.impl.UserValidatorImpl;

public final class UtilManager {

    private static final UtilManager instance = new UtilManager();

    public static UtilManager getInstance() {
        return instance;
    }

    private UtilManager() {

    }

    private final PasswordHashKeeper passwordHashKeeper = new PasswordHashKeeperImpl();
    private final UserValidator userValidator = new UserValidatorImpl();
    private final BrandValidator brandValidator = new BrandValidatorImpl();
    private final CategoryValidator categoryValidator = new CategoryValidatorImpl();
    private final ProductValidator productValidator = new ProductValidatorImpl();
    private final PaymentMethodValidator paymentMethodValidator = new PaymentMethodValidatorImpl();

    public PaymentMethodValidator getPaymentMethodValidator() {
        return paymentMethodValidator;
    }

    public ProductValidator getProductValidator() {
        return productValidator;
    }

    public CategoryValidator getCategoryValidator() {
        return categoryValidator;
    }

    public BrandValidator getBrandValidator() {
        return brandValidator;
    }

    public PasswordHashKeeper getPasswordHashKeeper() {
        return passwordHashKeeper;
    }

    public UserValidator getUserValidator() {
        return userValidator;
    }
}
