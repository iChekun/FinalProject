package by.epam.chekun.dao.impl.contacts;

import by.epam.chekun.dao.ContactsRepository;
import by.epam.chekun.dao.core.exception.JdbcTemplateException;
import by.epam.chekun.dao.exception.DAOException;
import by.epam.chekun.dao.exception.user.contacts.ContactsDAOException;
import by.epam.chekun.dao.exception.user.contacts.UsedEmailContactsException;
import by.epam.chekun.dao.initializer.InitializerRepository;
import by.epam.chekun.dao.mapper.ContactsRowMapper;
import by.epam.chekun.domain.entity.user.Contacts;

import java.util.List;

public class ContactsSqlRepository extends InitializerRepository implements ContactsRepository {


    @Override
    public Contacts getEntityById(String id) throws ContactsDAOException {

        try {
            return jdbcTemplate.queryForObject(GET_USER_CONTACTS,
                    new ContactsRowMapper(), id);
        } catch (JdbcTemplateException e) {
            throw new ContactsDAOException(e);
        }
    }

    @Override
    public boolean removeById(String id) {
        throw new UnsupportedOperationException("can`t remove contacts by id!");
    }

    @Override
    public Contacts getContactsByEmail(String email) throws ContactsDAOException {
        try {
            return jdbcTemplate.queryForObject(GET_USER_CONTACTS,
                    new ContactsRowMapper(), email);
        } catch (JdbcTemplateException e) {
            throw new ContactsDAOException(e);
        }
    }


    @Override
    public boolean add(Contacts contacts) throws ContactsDAOException {

        try {
            if (isEmailUsed(contacts.getEmail())) {
                throw new UsedEmailContactsException("email is already in use!");
            }

            jdbcTemplate.update(ADD_USER_CONTACTS,
                    contacts.getEmail(),
                    contacts.getPhoneNumber(),
                    contacts.getAddress().getCountry(),
                    contacts.getAddress().getCity(),
                    contacts.getAddress().getStreet(),
                    contacts.getAddress().getHouseNumber(),
                    contacts.getAddress().getApartmentNumber());
            return true;
        } catch (JdbcTemplateException e) {
            throw new ContactsDAOException(e);
        }
    }


    @Override
    public boolean update(Contacts contacts) throws DAOException {

        try {
            jdbcTemplate.update(UPDATE_CONTACTS,
                    contacts.getEmail(),
                    contacts.getPhoneNumber(),
                    contacts.getAddress().getCountry(),
                    contacts.getAddress().getCity(),
                    contacts.getAddress().getStreet(),
                    contacts.getAddress().getHouseNumber(),
                    contacts.getAddress().getApartmentNumber(),
                    contacts.getContactsId());
            return true;
        } catch (JdbcTemplateException e) {
            throw new ContactsDAOException(e);
        }
    }


    @Override
    public List<Contacts> getAll() throws ContactsDAOException {
        throw new UnsupportedOperationException("Can`t get all contacts! Try to user UserRepository");
    }

    @Override
    public boolean isEmailUsed(String email) throws ContactsDAOException {
        try {
            return jdbcTemplate.queryForObject(GET_USER_CONTACTS, email);
        } catch (JdbcTemplateException e) {
            throw new ContactsDAOException(e);
        }
    }


    private static final String ADD_USER_CONTACTS = "INSERT INTO contacts " +
            "(contactsId,email, phoneNumber, country, city, street, " +
            "houseNumber, apartmentNumber) " +
            "VALUES (UUID(), ?, ?, ?, ?,?, ?, ?)";

    private static final String GET_USER_CONTACTS =
            " SELECT contactsId, email, phoneNumber, country, city, street, " +
                    "   houseNumber, apartmentNumber FROM contacts WHERE email= ?";

    private static final String UPDATE_CONTACTS = "UPDATE Contacts " +
            "SET email=?, phoneNumber=?, country=?, city=?, street =?, houseNumber=?," +
            "apartmentNumber=?  WHERE contactsId=?";

}
