package by.epam.chekun.dao;

import by.epam.chekun.dao.exception.user.contacts.ContactsDAOException;
import by.epam.chekun.domain.entity.user.Contacts;

public interface ContactsRepository extends CrudRepository<Contacts> {
    Contacts getContactsByEmail(String email) throws ContactsDAOException;

    boolean isEmailUsed(String email) throws ContactsDAOException;
}
