package by.epam.chekun.domain.util.builder.user.impl;

import by.epam.chekun.domain.entity.user.Address;
import by.epam.chekun.domain.entity.user.Contacts;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;

public class ContactsBuilderImplTest {

    private ContactsBuilderImpl builder = new ContactsBuilderImpl();
    private ContactsBuilderImpl readyBuilder = new ContactsBuilderImpl("id");
    private Address address = mock(Address.class);

    @BeforeClass
    public void init() {
        readyBuilder.withEmail("user@mail.ru")
                .withAddress(address)
                .withPhoneNumber(293136052);
    }

    @Test
    public void testWithEmail() {
        builder.withEmail("user@mail.ru");

        assertEquals(builder.getEmail(), readyBuilder.getEmail());
    }

    @Test
    public void testWithPhoneNumber() {
        builder.withPhoneNumber(293136052);

        assertEquals(builder.getPhoneNumber(), readyBuilder.getPhoneNumber());
    }

    @Test
    public void testWithAddress() {
        builder.withAddress(address);

        assertEquals(builder.getAddress(), readyBuilder.getAddress());
    }

    @Test
    public void build_readyBuilder() {
        Contacts contacts = new Contacts();
        contacts.setContactsId("id");
        contacts.setAddress(address);
        contacts.setEmail("user@mail.ru");
        contacts.setPhoneNumber(293136052);

        Contacts result = readyBuilder.build();

        assertEquals(result, contacts);
    }

}