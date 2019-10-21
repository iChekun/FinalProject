
package by.epam.chekun.domain.util.builder.user.impl;

import by.epam.chekun.domain.entity.user.Contacts;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.entity.user.UserStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Timestamp;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class UserBuilderImplTest {


    private UserBuilderImpl builder = new UserBuilderImpl();
    private UserBuilderImpl readyBuilder = new UserBuilderImpl("id");

    private Contacts contacts = mock(Contacts.class);


    @BeforeClass
    public void init() {

        readyBuilder.withLogin("login")
                .withName("name")
                .withSurname("surname")
                .withContacts(contacts)
                .withBirthDate(new Timestamp(100000000))
                .isBanned(false)
                .withUserStatus(UserStatus.ADMIN);

    }

    @Test
    public void testWithContacts() {
        builder.withContacts(contacts);

        assertEquals(builder.getContacts(), contacts);
    }

    @Test
    public void testWithLogin() {
        builder.withLogin("login");

        assertEquals(builder.getLogin(), readyBuilder.getLogin());
    }

    @Test
    public void testWithPassword() {

    }

    @Test
    public void testWithName() {
        builder.withName("name");

        assertEquals(builder.getName(), readyBuilder.getName());
    }

    @Test
    public void testWithSurname() {
        builder.withSurname("surname");

        assertEquals(builder.getSurname(), readyBuilder.getSurname());
    }

    @Test
    public void testWithUserStatus() {
        builder.withUserStatus(UserStatus.ADMIN);

        assertEquals(builder.getUserStatus(), readyBuilder.getUserStatus());
    }

    @Test
    public void testWithBirthDate() {

        builder.withBirthDate(new Timestamp(100000000));
        //then
        assertEquals(builder.getBirthDate(), new Timestamp(100000000));
    }

    @Test
    public void testIsBanned() {
        builder.isBanned(false);
        //then
        assertFalse(builder.isBanned());
    }

    @Test
    public void testBuild() {
        User user = new User();
        user.setUserId("id");
        user.setBirthDate(new Timestamp(100000000));
        user.setName("name");
        user.setLogin("login");
        user.setSurname("surname");
        user.setBanned(false);
        user.setContacts(contacts);
        user.setUserStatus(UserStatus.ADMIN);

        User result = readyBuilder.build();

        assertEquals(result, user);
    }
}