package by.epam.chekun.dao.mapper;

import by.epam.chekun.dao.core.RowMapper;
import by.epam.chekun.dao.mapper.builder.impl.UserRowMapperBuilder;
import by.epam.chekun.domain.entity.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    private static final int USER_ID = 1;
    private static final int USER_STATUS_ID = 2;
    private static final int LOGIN = 3;
    private static final int NAME = 4;
    private static final int SURNAME = 5;
    private static final int BIRTH_DATE = 6;
    private static final int BANNED = 7;
    private static final int CONTACTS_ID = 8;
    private static final int EMAIL = 9;
    private static final int PHONE_NUMBER = 10;
    private static final int COUNTRY = 11;
    private static final int CITY = 12;
    private static final int STREET = 13;
    private static final int HOUSE_NUMBER = 14;
    private static final int APARTMENT_NUMBER = 15;

    @Override
    public User mapRow(final ResultSet set) throws SQLException {
        return
                new UserRowMapperBuilder(
                        USER_ID, USER_STATUS_ID, LOGIN,
                        NAME, SURNAME, BIRTH_DATE,
                        BANNED, CONTACTS_ID, EMAIL,
                        PHONE_NUMBER, COUNTRY, CITY,
                        STREET, HOUSE_NUMBER, APARTMENT_NUMBER)
                        .getBuiltEntity(set);
    }
}
