package by.epam.chekun.dao;

import by.epam.chekun.dao.exception.DAOException;
import by.epam.chekun.dao.exception.user.UserDAOException;
import by.epam.chekun.domain.entity.product.Product;
import by.epam.chekun.domain.entity.user.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User> {

    ///
    @Override
    User getEntityById(String id) throws DAOException;

    @Override
    boolean removeById(String id) throws UserDAOException;

    @Override
    boolean add(User product) throws DAOException;

    @Override
    boolean update(User product) throws DAOException;

    @Override
    List<User> getAll() throws DAOException;


    ///

    User getByLoginAndPass(String login, String encodedPass) throws UserDAOException;

    void updateBanStatus(String userId) throws UserDAOException;

    void updateUserStatus(String userId) throws UserDAOException;

    void updatePassword(String userId, String newEncodedPass) throws UserDAOException;

    List<User> getAllUserSorted(String sortedBy, String sortType) throws UserDAOException;

    boolean isLoginUser(String userId) throws UserDAOException;
}
