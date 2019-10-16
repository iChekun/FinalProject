package by.epam.chekun.dao;

import by.epam.chekun.dao.exception.DAOException;
import by.epam.chekun.dao.exception.user.UserDAOException;

import java.util.List;

public interface CrudRepository<T> {

    T getEntityById(String id) throws DAOException;

    boolean removeById(String id) throws DAOException;

    boolean add(T t) throws DAOException;

    boolean update(T t) throws DAOException;

    List<T> getAll() throws DAOException;

}
