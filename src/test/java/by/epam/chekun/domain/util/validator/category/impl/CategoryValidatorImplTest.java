package by.epam.chekun.domain.util.validator.category.impl;

import by.epam.chekun.domain.util.manager.UtilManager;
import by.epam.chekun.domain.util.validator.category.CategoryValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CategoryValidatorImplTest {

    private CategoryValidator validator = UtilManager.getInstance().getCategoryValidator();


    @Test
    public void validateCategory_correctCategory_true(){
        boolean result = validator.validate("phones","top and good");

        assertTrue(result);
    }

    @Test
    public void validateCategory_wrongCategory_false(){
        boolean result= validator.validate("a","a");

        assertFalse(result);
    }


}