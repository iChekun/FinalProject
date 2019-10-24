package by.epam.chekun.domain.service.impl.user;

import by.epam.chekun.dao.ContactsRepository;
import by.epam.chekun.dao.UserRepository;
import by.epam.chekun.dao.exception.DAOException;
import by.epam.chekun.dao.exception.user.InvalidLoginOrPasswordException;
import by.epam.chekun.dao.exception.user.UsedLoginException;
import by.epam.chekun.dao.exception.user.UserDAOException;
import by.epam.chekun.dao.exception.user.contacts.UsedEmailContactsException;
import by.epam.chekun.dao.manager.DAOManager;
import by.epam.chekun.domain.entity.user.Address;
import by.epam.chekun.domain.entity.user.Contacts;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.entity.user.UserStatus;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.user.*;
import by.epam.chekun.domain.util.builder.user.impl.AddressBuilderImpl;
import by.epam.chekun.domain.util.builder.user.impl.ContactsBuilderImpl;
import by.epam.chekun.domain.util.builder.user.impl.UserBuilderImpl;
import by.epam.chekun.domain.util.hasher.PasswordHashKeeper;
import by.epam.chekun.domain.util.manager.UtilManager;
import by.epam.chekun.domain.util.validator.user.UserValidator;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository = DAOManager.getInstance().getUserRepository();
    private final ContactsRepository contactsRepository = DAOManager.getInstance().getContactsRepository();
    private final PasswordHashKeeper keeper = UtilManager.getInstance().getPasswordHashKeeper();
    private final UserValidator validator = UtilManager.getInstance().getUserValidator();

    @Override
    public User getById(final String userId) throws UserServiceException {
        try {
            final User user = userRepository.getEntityById(userId);
            return user;
        } catch (DAOException ex) {
            throw new UserServiceException(ex);
        }
    }

    @Override
    public User signIn(final String login, final String password) throws UserServiceException {
        if (!validator.validate(login, password)) {
            throw new InvalidUserInformationException("Information is not valid!");
        }
        final String encodedPass = keeper.generateHash(login, password);

        try {
            final User user = userRepository.getByLoginAndPass(login, encodedPass);

            if (user == null) {
                throw new InvalidLoginOrPasswordException("wrong user data!");
            }

            if (user.getBanned()) {
                throw new BannedUserServiceException("User is banned!");
            }

            return user;
        } catch (InvalidLoginOrPasswordException ex) {
            throw new InvalidUserInformationException(ex);
        } catch (DAOException ex) {
            throw new UserServiceException(ex);
        }
    }

    @Override
    public void add(final String login, final String password, final String confirmedPassword,
                    final String name, final String surname, final Date birthDate,
                    final String email, final String phoneNumber,
                    final String country, final String city, final String street,
                    final int houseNumber, final int apartmentNumber)
            throws UserServiceException {

        if (!validator.validate(login, password, confirmedPassword,
                name, surname, birthDate, email, phoneNumber
                , country, city, street, houseNumber, apartmentNumber)) {
            throw new InvalidUserInformationException("Information is not valid!");
        }

        try {
            final Address address = new AddressBuilderImpl()
                    .withCountry(country)
                    .withCity(city)
                    .withStreet(street)
                    .withHouseNumber(houseNumber)
                    .withApartmentNumber(apartmentNumber)
                    .build();

            Contacts contacts = new ContactsBuilderImpl()
                    .withEmail(email)
                    .withPhoneNumber(Long.valueOf(phoneNumber))
                    .withAddress(address)
                    .build();

            contactsRepository.add(contacts);
            contacts = contactsRepository.getContactsByEmail(email);


            final String encodedPass = keeper.generateHash(login, password);

            final User user = new UserBuilderImpl()
                    .withLogin(login)
                    .withPassword(encodedPass)
                    .withName(name)
                    .withSurname(surname)
                    .withBirthDate(new Timestamp(birthDate.getTime() + 11000 * 1000))
                    .isBanned(false)
                    .withContacts(contacts)
                    .withUserStatus(UserStatus.CUSTOMER)
                    .build();


            userRepository.add(user);
        } catch (UsedLoginException e) {
            throw new InvalidLoginException(e);
        } catch (UsedEmailContactsException e) {
            throw new InvalidEmailException(e);
        } catch (DAOException e) {
            throw new UserServiceException(e);
        }
    }

    @Override
    public List<User> getAll() throws UserServiceException {
        try {
            final List<User> users = userRepository.getAll();
            return users;
        } catch (DAOException e) {
            throw new UserServiceException(e);
        }
    }


    @Override
    public void changeBanStatus(final String userId) throws UserServiceException {
        try {
            userRepository.updateBanStatus(userId);
        } catch (DAOException e) {
            throw new UserServiceException(e);
        }
    }

    @Override
    public void changeUserStatus(final String userId) throws UserServiceException {
        try {
            userRepository.updateUserStatus(userId);
        } catch (DAOException e) {
            throw new UserServiceException(e);
        }
    }


    @Override
    public List<User> getAllUsersSorted(final String sortedBy, final String sortType) throws UserServiceException {
        try {
            final List<User> usersSortedList = userRepository.getAllUserSorted(sortedBy, sortType);
            return usersSortedList;
        } catch (DAOException e) {
            throw new UserServiceException(e);
        }
    }


    @Override
    public void update(final String userId, final int userStatusId, final boolean banned,
                       final String login,
                       final String name, final String surname, final Date birthDate,
                       final String contactsId, final String email, final String phoneNumber,
                       final String country, final String city, final String street,
                       final int houseNumber, final int apartmentNumber) throws UserServiceException {
        if (!validator.validate(login,
                name, surname, birthDate, email, phoneNumber, country, city, street, houseNumber, apartmentNumber)) {
            throw new InvalidUserInformationException("Can`t edit user! Info is not valid!");
        }

        try {
            final Address address = new AddressBuilderImpl()
                    .withCountry(country)
                    .withCity(city)
                    .withStreet(street)
                    .withHouseNumber(houseNumber)
                    .withApartmentNumber(apartmentNumber)
                    .build();

            final Contacts contacts = new ContactsBuilderImpl(contactsId)
                    .withEmail(email)
                    .withPhoneNumber(Long.valueOf(phoneNumber))
                    .withAddress(address)
                    .build();

            contactsRepository.update(contacts);
            //

            final User user = new UserBuilderImpl()
                    .withLogin(login)
                    .withName(name)
                    .withSurname(surname)
                    .withBirthDate(new Timestamp(birthDate.getTime() + 11000 * 1000))
                    .isBanned(false)
                    .withUserStatus(UserStatus.CUSTOMER)
                    .withContacts(contacts)
                    .build();
            userRepository.update(user);
        } catch (UsedLoginException e) {
            throw new InvalidLoginException(e);
        } catch (UsedEmailContactsException e) {
            throw new InvalidEmailException(e);
        } catch (DAOException e) {
            throw new UserServiceException(e);
        }
    }

    @Override
    public void changePassword(String userId, String currentPassword,
                               String newPassword, String confirmedPassword) throws UserServiceException {
        if (!validator.validatePassword(currentPassword, newPassword, confirmedPassword)) {
            throw new InvalidUserInformationException("Info not valid!");
        }

        try {
            final User user = getById(userId);
            final String login = user.getLogin();
            //
            final String encodedCurrentPassword = keeper.generateHash(login, currentPassword);
            final String encodedNewPassword = keeper.generateHash(login, newPassword);
            //
            userRepository.getByLoginAndPass(login, encodedCurrentPassword);
            userRepository.updatePassword(userId, encodedNewPassword);
            //
        } catch (InvalidLoginOrPasswordException ex) {
            throw new InvalidPasswordException(ex);
        } catch (UserDAOException e) {
            throw new UserServiceException(e);
        }
    }
}
