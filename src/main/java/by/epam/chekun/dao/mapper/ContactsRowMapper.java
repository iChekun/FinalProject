package by.epam.chekun.dao.mapper;

import by.epam.chekun.dao.core.RowMapper;
import by.epam.chekun.dao.mapper.builder.impl.ContactsRowMapperBuilder;
import by.epam.chekun.domain.entity.user.Contacts;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactsRowMapper implements RowMapper<Contacts> {

    private static final int CONTACTS_ID = 1;
    private static final int EMAIL = 2;
    private static final int PHONE_NUMBER = 3;
    private static final int COUNTRY = 4;
    private static final int CITY = 5;
    private static final int STREET = 6;
    private static final int HOUSE_NUMBER = 7;
    private static final int APARTMENT_NUMBER = 8;

    @Override
    public Contacts mapRow(ResultSet set) throws SQLException {
        return
                new ContactsRowMapperBuilder(
                        CONTACTS_ID, EMAIL,
                        PHONE_NUMBER, COUNTRY,
                        CITY, STREET, HOUSE_NUMBER,
                        APARTMENT_NUMBER)
                        .getBuiltEntity(set);
    }
}
