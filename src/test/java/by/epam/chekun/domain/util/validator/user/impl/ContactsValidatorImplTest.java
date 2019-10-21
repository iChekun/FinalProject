package by.epam.chekun.domain.util.validator.user.impl;

import by.epam.chekun.domain.util.validator.user.ContactsValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
public class ContactsValidatorImplTest {

    private ContactsValidator validator = new ContactsValidatorImpl();


    @Test
    public void testValidate_correctParams_true() {
        boolean result = validator.validate("nykech_2@mail.ru", "375293136052", "беларусь", "минск",
                "лобавнка", 52, 191);

        assertTrue(result);
    }

    @Test
    public void testValidate_badEmail_false(){
        boolean result = validator.validate("bademail","375293136052",
                "беларусь","минск","лобанка",62,182);

        assertFalse(result);
    }

    @Test
    public void testValidate_badTelefon_false(){
        boolean result = validator.validate("nykech@mail.ru","+375-29-313-60-52",
                "беларусь","минск","лобанка",62,182);

        assertTrue(result);
    }
}