package by.epam.chekun.dao.impl.user;

import by.epam.chekun.dao.InitializerRepository;
import by.epam.chekun.dao.UserRepository;
import by.epam.chekun.dao.core.exception.JdbcTemplateException;
import by.epam.chekun.dao.exception.user.InvalidLoginOrPasswordException;
import by.epam.chekun.dao.exception.user.UsedLoginException;
import by.epam.chekun.dao.exception.user.UserDAOException;
import by.epam.chekun.dao.mapper.UserRowMapper;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.entity.user.UserStatus;

import java.util.List;

import static by.epam.chekun.dao.impl.user.UserSqlUtil.*;

public class UserSqlRepository extends InitializerRepository implements UserRepository {


    @Override
    public User getEntityById(String id) throws UserDAOException {
        try {
            User user = jdbcTemplate.queryForObject(GET_USER_BY_ID, new UserRowMapper(), id);
            return user;
        } catch (JdbcTemplateException e) {
            throw new UserDAOException(e);
        }
    }

    @Override
    public boolean removeById(String id) throws UserDAOException {

        return false;
    }


    @Override
    public boolean add(User user) throws UserDAOException {
        try {

            if (isLoginUser(user.getLogin())) {
                throw new UsedLoginException("Login is already in use!");
            }

            jdbcTemplate.update(ADD_NEW_USER,
                    user.getContacts().getContactsId(),
                    user.getUserStatus().getUserStatusId(),
                    user.getLogin(),
                    user.getPassword(),
                    user.getName(),
                    user.getSurname(),
                    user.getBirthDate(),
                    user.getBanned());
            return true;
        } catch (JdbcTemplateException e) {
            throw new UserDAOException(e);
        }
    }

    @Override
    public boolean update(User user) throws UserDAOException {

        try {
            jdbcTemplate.update(UPDATE_USER,
                    user.getContacts().getContactsId(),
                    user.getLogin(),
                    user.getName(),
                    user.getSurname(),
                    user.getBirthDate(),
                    user.getBanned(),
                    user.getUserId());

            return true;
        } catch (JdbcTemplateException e) {
            throw new UserDAOException(e);
        }
    }


    @Override
    public List getAll() throws UserDAOException {
        List<User> users = _getAll(GET_ALL_USERS);
        return users;
    }


    @Override
    public User getByLoginAndPass(String login, String encodedPass) throws UserDAOException {
        try {
            User user = jdbcTemplate.queryForObject(GET_USER_BY_LOGIN_AND_PASS,
                    new UserRowMapper(), login, encodedPass);
            if (user == null) {
                throw new InvalidLoginOrPasswordException("wrong user data!");
            }
            return user;
        } catch (JdbcTemplateException e) {
            throw new UserDAOException(e);
        }
    }

    @Override
    public void updateBanStatus(String userId) throws UserDAOException {
        try {
            final User user = getEntityById(userId);
            final boolean banned = !user.getBanned();
            //
            jdbcTemplate.update(UPDATE_BAN_STATUS, banned, userId);
        } catch (JdbcTemplateException e) {
            throw new UserDAOException(e);
        }
    }

    @Override
    public void updateUserStatus(String userId) throws UserDAOException {
        try {
            final User user = getEntityById(userId);
            final int statusId = user.getUserStatus().getUserStatusId() == UserStatus.ADMIN.getUserStatusId() ?
                    UserStatus.CUSTOMER.getUserStatusId() :
                    UserStatus.ADMIN.getUserStatusId();

            //
            jdbcTemplate.update(UPDATE_USER_STATUS, statusId, userId);
        } catch (JdbcTemplateException e) {
            throw new UserDAOException(e);
        }
    }

    @Override
    public void updatePassword(String userId, String newEncodedPass) throws UserDAOException {
        try {
            jdbcTemplate.update(UPDATE_USER_PASSWORD, newEncodedPass);
        } catch (JdbcTemplateException e) {
            throw new UserDAOException(e);
        }
    }

    @Override
    public List<User> getAllUserSorted(String sortedBy, String sortType) throws UserDAOException {
        String sql = getSortingSql(sortedBy, sortType);
        List<User> users = _getAll(sql);
        return users;
    }

    private String getSortingSql(String sortBy, String sortType) throws UserDAOException {
        switch (sortBy) {
            case SORT_USERS_BY_SURNAME:
                return SORT_TYPE_ASC.equals(sortType) ?
                        GET_ALL_USERS_SORTED_BY_SURNAME_ASC :
                        GET_ALL_USERS_SORTED_BY_SURNAME_DESC;
            case SORT_USERS_BY_BIRTH_DATE:
                return SORT_TYPE_ASC.equals(sortType) ?
                        GET_ALL_USERS_SORTED_BY_BIRTH_DATE_ASC :
                        GET_ALL_USERS_SORTED_BY_BIRTH_DATE_DESC;

            case SORT_USERS_BY_NAME:
                return SORT_TYPE_ASC.equals(sortType) ?
                        GET_ALL_USERS_SORTED_BY_NAME_ASC :
                        GET_ALL_USERS_SORTED_BY_NAME_DESC;
            default:
                break;
        }
        throw new UserDAOException("No sorting SQL for params: " + sortBy + " and " + sortType);
    }


    private List<User> _getAll(final String sql) throws UserDAOException {
        try {
            List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
            return users;
        } catch (JdbcTemplateException e) {
            throw new UserDAOException(e);
        }
    }

    @Override
    public boolean isLoginUser(String login) throws UserDAOException {
        try {
            boolean res = jdbcTemplate.queryForObject(GET_USER_BY_LOGIN, login);
            return res;
        } catch (JdbcTemplateException e) {
            throw new UserDAOException(e);
        }
    }
}
