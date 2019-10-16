package by.epam.chekun.dao.impl.category;

import by.epam.chekun.dao.CategoryRepository;
import by.epam.chekun.dao.InitializerRepository;
import by.epam.chekun.dao.core.exception.JdbcTemplateException;
import by.epam.chekun.dao.exception.category.CategoryDAOException;
import by.epam.chekun.dao.exception.category.UsedCategoryNameException;

import by.epam.chekun.dao.mapper.CategoryRowMapper;
import by.epam.chekun.domain.entity.category.Category;

import java.util.List;

import static by.epam.chekun.dao.impl.category.CategorySqlUtil.*;

public class CategorySqlRepository extends InitializerRepository implements CategoryRepository {


    @Override
    public Category getEntityById(String id) throws CategoryDAOException {
        try {
            final Category category = jdbcTemplate.queryForObject(GET_CATEGORY_BY_ID,
                    new CategoryRowMapper(), id);
            return category;
        } catch (JdbcTemplateException e) {
            throw new CategoryDAOException(e);
        }
    }

    @Override
    public boolean removeById(String id) throws CategoryDAOException {
        try {
            jdbcTemplate.update(DELETE_CATEGORY_BY_ID, id);
            return true;
        } catch (JdbcTemplateException e) {
            throw new CategoryDAOException(e);
        }
    }

    @Override
    public boolean add(Category category) throws CategoryDAOException {

        try {
            if (isCategoryNameUsed(category.getName())) {
                throw new UsedCategoryNameException("name is already in use!");
            }

            jdbcTemplate.update(ADD_NEW_CATEGORY,
                    category.getName(),
                    category.getDescription(),
                    category.getImagePath());

            return true;
        } catch (JdbcTemplateException e) {
            throw new CategoryDAOException(e);
        }
    }

    @Override
    public boolean update(Category category) throws CategoryDAOException {

        try {
            jdbcTemplate.update(UPDATE_CATEGORY,
                    category.getName(),
                    category.getDescription(),
                    category.getImagePath(),
                    category.getCategoryId());

            return true;
        } catch (JdbcTemplateException e) {
            throw new CategoryDAOException(e);
        }
    }

    @Override
    public List<Category> getAll() throws CategoryDAOException {

        try {
            List<Category> categories = jdbcTemplate.query(GET_ALL_CATEGORIES, new CategoryRowMapper());
            return categories;
        } catch (JdbcTemplateException e) {
            throw new CategoryDAOException(e);
        }
    }


    private boolean isCategoryNameUsed(String name) throws JdbcTemplateException {
        boolean result = jdbcTemplate.queryForObject(GET_CATEGORY_ID_BY_NAME, name);
        return result;
    }
}
