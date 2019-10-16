package by.epam.chekun.domain.service;

import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.service.exception.ServiceException;

import java.util.List;

public interface CategoryService {

    void add(String name,
             String description, String imagePath) throws ServiceException;

    List<Category> getAll() throws ServiceException;

    void update(String categoryId, String name,
                String description, String imagePath) throws ServiceException;


    void delete(String categoryId) throws ServiceException;

    Category getById(String categoryId) throws ServiceException;
}
