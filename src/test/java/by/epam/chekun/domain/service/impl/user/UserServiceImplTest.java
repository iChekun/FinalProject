package by.epam.chekun.domain.service.impl.user;

import by.epam.chekun.dao.ContactsRepository;
import by.epam.chekun.dao.UserRepository;
import by.epam.chekun.dao.exception.DAOException;
import by.epam.chekun.dao.exception.user.UserDAOException;
import by.epam.chekun.domain.entity.user.Contacts;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.service.exception.user.BannedUserServiceException;
import by.epam.chekun.domain.service.exception.user.UserServiceException;
import by.epam.chekun.domain.util.hasher.PasswordHashKeeper;
import by.epam.chekun.domain.util.validator.user.UserValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class UserServiceImplTest {

    private UserServiceImpl service = new UserServiceImpl();
    private UserValidator validator = mock(UserValidator.class);
    private ContactsRepository contactsRepository = mock(ContactsRepository.class);
    private PasswordHashKeeper keeper = mock(PasswordHashKeeper.class);
    private UserRepository userRepository = mock(UserRepository.class);


    @BeforeClass
    public void init() {
        service.setContactsRepository(contactsRepository);
        service.setKeeper(keeper);
        service.setUserRepository(userRepository);
        service.setValidator(validator);
    }


    @Test(expectedExceptions = UserServiceException.class)
    public void testGetById_serviceException() throws UserServiceException, DAOException {
        //given
        //when
        User user = mock(User.class);
        doThrow(UserServiceException.class).when(userRepository).getEntityById(anyString());
        service.getById(anyString());
        //doThrow(UserServiceException.class).when(userRepository).getByLoginAndPass(anyString(), anyString());
        //UserServiceException
    }


    @Test(expectedExceptions = UserServiceException.class)
    public void testGetById_valid() throws UserServiceException, DAOException {
        //given
        //when
        doThrow(UserServiceException.class).when(userRepository).getEntityById(anyString());
        service.getById(anyString());
        //doThrow(UserServiceException.class).when(userRepository).getByLoginAndPass(anyString(), anyString());
        //UserServiceException
    }


    @Test(expectedExceptions = UserServiceException.class)
    public void testSignIn_invalidParameters() throws UserServiceException {
        //given
        //when
        when(validator.validate(anyString(), anyString())).thenReturn(false);
        service.signIn("Invalid", "Info");
        //then
        //expecting InvalidUserInformationException
    }

    @Test
    public void testSignIn_valid_params() throws UserDAOException, UserServiceException {
        //given
        User user = mock(User.class);
        //when
        //when
        when(validator.validate(anyString(), anyString())).thenReturn(true);
        doReturn(user).when(userRepository).getByLoginAndPass(anyString(), anyString());
        when(user.getBanned()).thenReturn(false);
        User result = service.signIn("Username", "Password");
        //then
        assertEquals(result, user);
    }


    @Test(expectedExceptions = BannedUserServiceException.class)
    public void testSignIn_bannedUser() throws DAOException, UserServiceException {
        //given
        User user = mock(User.class);
        //when
        doThrow(BannedUserServiceException.class).when(userRepository).getEntityById(anyString());
        User result = service.getById(anyString());
        //then
        assertEquals(result, user);
    }

    @Ignore
    @Test
    public void testAdd() throws DAOException {
        when(validator.validate(anyString(), anyString(), anyString(),
                anyString(), anyString(), anyObject(),
                anyString(), anyString(),
                anyString(), anyString(), anyString(),
                anyInt(), anyInt())).thenReturn(true);
        Contacts contacts = mock(Contacts.class);

        when(contactsRepository.add(contacts)).thenReturn(true);
        doReturn(contacts).when(contactsRepository.getContactsByEmail(anyString()));
        doReturn(anyString()).when(keeper.generateHash(anyString(), anyString()));
        User user = mock(User.class);

        when(userRepository.add(user));

    }

    @Test
    public void testGetAll() {
    }

    @Test
    public void testChangeBanStatus() {
    }

    @Test
    public void testChangeUserStatus() {
    }

    @Test
    public void testGetAllUsersSorted() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testChangePassword() {

    }
}