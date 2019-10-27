package by.epam.chekun.dao;

import by.epam.chekun.dao.exception.category.CategoryDAOException;
import by.epam.chekun.dao.initializer.CrudRepository;
import by.epam.chekun.domain.entity.category.Category;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category> {


    @Override
    Category getEntityById(String id) throws CategoryDAOException;

    @Override
    boolean removeById(String id) throws CategoryDAOException;

    @Override
    boolean add(Category category) throws CategoryDAOException;

    @Override
    boolean update(Category category) throws CategoryDAOException;

    @Override
    List<Category> getAll() throws CategoryDAOException;
}
