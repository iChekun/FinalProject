package by.epam.chekun.dao.mapper.builder.impl;

import by.epam.chekun.dao.mapper.builder.RowMapperBuilder;
import by.epam.chekun.domain.entity.user.Address;
import by.epam.chekun.domain.entity.user.Contacts;
import by.epam.chekun.domain.util.builder.user.impl.AddressBuilderImpl;
import by.epam.chekun.domain.util.builder.user.impl.ContactsBuilderImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactsRowMapperBuilder implements RowMapperBuilder<Contacts> {

    private final int CONTACTS_ID;
    private final int EMAIL;
    private final int PHONE_NUMBER;
    private final int COUNTRY;
    private final int CITY;
    private final int STREET;
    private final int HOUSE_NUMBER;
    private final int APARTMENT_NUMBER;


    public ContactsRowMapperBuilder(int CONTACTS_ID, int EMAIL,
                                    int PHONE_NUMBER, int COUNTRY,
                                    int CITY, int STREET, int HOUSE_NUMBER,
                                    int APARTMENT_NUMBER) {
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
    public Contacts getBuiltEntity(ResultSet set) throws SQLException {
        return buildContacts(set);
    }

    private Contacts buildContacts(ResultSet set) throws SQLException {
        ///////////////////////////////////////////////////////////
        final Address address = getAddress(set);
        ///////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////
        return getContacts(set, address);
    }

    private Contacts getContacts(ResultSet set, Address address) throws SQLException {
        return
                new ContactsBuilderImpl(set.getString(CONTACTS_ID))
                        .withEmail(set.getString(EMAIL))
                        .withPhoneNumber(Long.valueOf(set.getString(PHONE_NUMBER)))
                        .withAddress(address)
                        .build();
    }

    private Address getAddress(ResultSet set) throws SQLException {
        return
                new AddressBuilderImpl().withCountry(set.getString(COUNTRY))
                        .withCity(set.getString(CITY))
                        .withStreet(set.getString(STREET))
                        .withHouseNumber(set.getInt(HOUSE_NUMBER))
                        .withApartmentNumber(set.getInt(APARTMENT_NUMBER))
                        .build();
    }
}
