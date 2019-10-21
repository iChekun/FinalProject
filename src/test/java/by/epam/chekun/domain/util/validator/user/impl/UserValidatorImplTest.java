package by.epam.chekun.domain.util.validator.user.impl;

import by.epam.chekun.domain.util.manager.UtilManager;
import by.epam.chekun.domain.util.validator.user.UserValidator;
import org.testng.annotations.Test;

import java.sql.Date;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UserValidatorImplTest {

    private final UserValidator validator = UtilManager.getInstance().getUserValidator();

    @Test
    public void testValidate_shortUserName() {

        boolean result = validator.validate("short", "[assword");

        assertFalse(result);
    }

    @Test
    public void testValidate_incorrect_userNameEnd() {
        boolean result = validator.validate("incorrect-", "pass");

        assertFalse(result);
    }

    @Test
    public void testValidate_longUserName() {
        boolean result = validator.validate("LongLongLongUserName", "pass");

        assertFalse(result);
    }

    @Test
    public void testValidatePassword_underscoreAltPasswordBeginning() {

        boolean result = validator.validate("username", "_wrongPassword");

        assertFalse(result);
    }


    @Test
    public void validateWithTwoParams_longPassword_false() {
        //given
        //when
        boolean result = validator.validate("Username",
                "PasswordPasswordPasswordPassword");
        //then
        assertFalse(result);
    }

    @Test
    public void validateWithTwoParams_validParameters_true() {
        //given
        //when
        boolean result = validator.validate("Username", "Password");
        //then
        assertTrue(result);
    }


    @Test
    public void validate_changePassword_false() {

        boolean result = validator.validatePassword("pass", "pass", "pass");

        assertFalse(result);
    }

    @Test
    public void validate_changePassword_true() {

        boolean result = validator.validatePassword("passs1999", "life1999", "life1999");

        assertTrue(result);
    }


    @Test
    public void validate_userWithAllParameters_true() {

        boolean result = validator.validate("nykech", "life1999", "chekun", Date.valueOf("2019-12-10"),
                "nykech@mail.ru", "+375293136052", "belarus", "minsk", "lobanka",
                52, 191);

        assertTrue(result);
    }





}