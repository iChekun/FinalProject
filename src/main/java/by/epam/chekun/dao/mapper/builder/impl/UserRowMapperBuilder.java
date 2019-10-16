package by.epam.chekun.dao.mapper.builder.impl;

import by.epam.chekun.dao.mapper.builder.RowMapperBuilder;
import by.epam.chekun.domain.entity.user.Contacts;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.entity.user.UserStatus;
import by.epam.chekun.domain.util.builder.user.impl.UserBuilderImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapperBuilder implements RowMapperBuilder<User> {

    private final int USER_ID;
    private final int USER_STATUS_ID;
    private final int LOGIN;
    private final int NAME;
    private final int SURNAME;
    private final int BIRTH_DATE;
    private final int BANNED;
    private final int CONTACTS_ID;
    private final int EMAIL;
    private final int PHONE_NUMBER;
    private final int COUNTRY;
    private final int CITY;
    private final int STREET;
    private final int HOUSE_NUMBER;
    private final int APARTMENT_NUMBER;


    public UserRowMapperBuilder(int USER_ID, int USER_STATUS_ID, int LOGIN,
                                int NAME, int SURNAME, int BIRTH_DATE,
                                int BANNED, int CONTACTS_ID, int EMAIL,
                                int PHONE_NUMBER, int COUNTRY, int CITY,
                                int STREET, int HOUSE_NUMBER, int APARTMENT_NUMBER) {
        this.USER_ID = USER_ID;
        this.USER_STATUS_ID = USER_STATUS_ID;
        this.LOGIN = LOGIN;
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.BIRTH_DATE = BIRTH_DATE;
        this.BANNED = BANNED;
        this.CONTACTS_ID = CONTACTS_ID;
        this.EMAIL = EMAIL;
        this.PHONE_NUMBER = PHONE_NUMBER;
        this.COUNTRY = COUNTRY;
        this.CITY = CITY;
        this.STREET = STREET;
        this.HOUSE_NUMBER = HOUSE_NUMBER;
        this.APARTMENT_NUMBER = APARTMENT_NUMBER;
    }

    @Override
    public User getBuiltEntity(ResultSet set) throws SQLException {
        return buildUser(set);
    }

    private User buildUser(final ResultSet set) throws SQLException {
        ///////////////////////////////////////////////////////////
        final Contacts contacts = getContacts(set);
        ///////////////////////////////////////////////////////////
        return getUser(set, contacts);
    }

    private User getUser(ResultSet set, Contacts contacts) throws SQLException {
        final int userStatusId = set.getInt(USER_STATUS_ID) - 1; // because arrays start from 0
        final UserStatus userStatus = UserStatus.values()[userStatusId];
        final String userId = set.getString(USER_ID);
        return new UserBuilderImpl(userId)
                .withLogin(set.getString(LOGIN))
                .withName(set.getString(NAME))
                .withSurname(set.getString(SURNAME))
                .withBirthDate(set.getTimestamp(BIRTH_DATE))
                .isBanned(set.getBoolean(BANNED))
                .withUserStatus(userStatus)
                .withContacts(contacts)
                .build();
    }

    private Contacts getContacts(ResultSet set) throws SQLException {
        return new ContactsRowMapperBuilder(
                CONTACTS_ID, EMAIL,
                PHONE_NUMBER, COUNTRY,
                CITY, STREET, HOUSE_NUMBER,
                APARTMENT_NUMBER).getBuiltEntity(set);
    }


}
