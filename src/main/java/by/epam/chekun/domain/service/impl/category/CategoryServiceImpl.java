package by.epam.chekun.domain.service.impl.category;

import by.epam.chekun.dao.CategoryRepository;
import by.epam.chekun.dao.exception.DAOException;
import by.epam.chekun.dao.exception.category.CategoryDAOException;
import by.epam.chekun.dao.exception.category.UsedCategoryNameException;
import by.epam.chekun.dao.manager.DAOManager;
import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.service.CategoryService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.category.CategoryServiceException;
import by.epam.chekun.domain.service.exception.category.InvalidCategoryInformationException;
import by.epam.chekun.domain.service.exception.category.UsedCategoryNameServiceException;
import by.epam.chekun.domain.util.builder.category.impl.CategoryBuilderImpl;
import by.epam.chekun.domain.util.manager.UtilManager;
import by.epam.chekun.domain.util.validator.category.CategoryValidator;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository = DAOManager.getInstance().getCategoryRepository();
    private final CategoryValidator validator = UtilManager.getInstance().getCategoryValidator();

    @Override
    public void add(String name,
                    String description, String imagePath) throws CategoryServiceException {

        if (!validator.validate(name, description)) {
            throw new InvalidCategoryInformationException("Invalid category info!");
        }

        final Category category = new CategoryBuilderImpl()
                .withName(name)
                .withDescription(description)
                .withImagePath(imagePath)
                .build();

        try {
            categoryRepository.add(category);
        } catch (UsedCategoryNameException e) {
            throw new UsedCategoryNameServiceException(e);
        } catch (DAOException e) {
            throw new CategoryServiceException(e);
        }
    }


    @Override
    public List<Category> getAll() throws CategoryServiceException {
        try {
            List<Category> categories = categoryRepository.getAll();
            return categories;
        } catch (DAOException e) {
            throw new CategoryServiceException(e);
        }
    }

    @Override
    public void update(String categoryId, String name, String description, String imagePath) throws CategoryServiceException {
        if (!validator.validate(name, description)) {
            throw new InvalidCategoryInformationException("Invalid category info!");
        }
        try {
            final Category category = new CategoryBuilderImpl(categoryId)
                    .withName(name)
                    .withDescription(description)
                    .withImagePath(imagePath)
                    .build();

            categoryRepository.update(category);
        } catch (CategoryDAOException e) {
            throw new CategoryServiceException(e);
        }
    }


    @Override
    public void delete(String categoryId) throws CategoryServiceException {
        try {
            categoryRepository.removeById(categoryId);
        } catch (CategoryDAOException e) {
            throw new CategoryServiceException(e);
        }
    }


    @Override
    public Category getById(String categoryId) throws CategoryServiceException {
        try {
            return categoryRepository.getEntityById(categoryId);
        } catch (CategoryDAOException e) {
            throw new CategoryServiceException(e);
        }
    }
}
