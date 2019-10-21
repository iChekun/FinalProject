package by.epam.chekun.domain.util.validator.user.impl;

import by.epam.chekun.domain.util.validator.user.AddressValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AddressValidatorImplTest {

    private AddressValidator validator = new AddressValidatorImpl();

    @Test
    public void testValidate_correctAddress_true() {

        boolean result = (validator.validate("belarus", "minsk", "lobanka", 62, 191));

        assertTrue(result);
    }

    @Test
    public void testValidate_correctAddress_false() {

        boolean result = (validator.validate("belarus", "mi", "lobanka", 0, 0));

        assertFalse(result);
    }
}