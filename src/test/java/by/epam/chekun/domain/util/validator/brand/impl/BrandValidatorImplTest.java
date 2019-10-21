package by.epam.chekun.domain.util.validator.brand.impl;

import by.epam.chekun.domain.util.manager.UtilManager;
import by.epam.chekun.domain.util.validator.brand.BrandValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
public class BrandValidatorImplTest {

    private BrandValidator validator = UtilManager.getInstance().getBrandValidator();

    @Test
    public void testValidate_correctBrand_true() {
        boolean result = validator.validate("samsung","top brand of phones");

        assertTrue(result);
    }


    @Test
    public void testValidate_wrongBrand_false() {
        boolean result = validator.validate("s","top brand of phones");

        assertFalse(result);
    }
}