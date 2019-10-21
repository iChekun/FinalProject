package by.epam.chekun.domain.util.validator.paymentmethod.impl;

import by.epam.chekun.domain.util.manager.UtilManager;
import by.epam.chekun.domain.util.validator.paymentmethod.PaymentMethodValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PaymentMethodValidatorImplTest {

    private PaymentMethodValidator validator = UtilManager.getInstance().getPaymentMethodValidator();

    @Test
    public void testValidate_correctName_true() {

        boolean result = validator.validate("cash");

        assertTrue(result);
    }

    @Test
    public void testValidate_badName_false() {

        boolean result = validator.validate("c");

        assertFalse(result);
    }
}