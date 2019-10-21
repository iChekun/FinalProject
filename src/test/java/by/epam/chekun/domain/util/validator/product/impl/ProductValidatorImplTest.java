package by.epam.chekun.domain.util.validator.product.impl;

import by.epam.chekun.domain.util.manager.UtilManager;
import by.epam.chekun.domain.util.validator.product.ProductValidator;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ProductValidatorImplTest {

    private ProductValidator validator = UtilManager.getInstance().getProductValidator();

    @Test
    public void testValidate_correctProduct_true() {
        boolean result = validator.validate("a-90", "big", "2500");

        assertTrue(result);
    }

    @Test
    public void testValidate_wrongCostProduct_false() {
        boolean result = validator.validate("a-90", "big", "po");

        assertFalse(result);
    }

    @Test
    public void testValidate_wrongNameProduct_false() {
        boolean result = validator.validate("a", "big", "po");

        assertFalse(result);
    }
}