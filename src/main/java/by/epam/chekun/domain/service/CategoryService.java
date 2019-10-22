package by.epam.chekun.domain.service;

import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.category.CategoryServiceException;

import java.util.List;

public interface CategoryService {

    void add(String name,
             String description, String imagePath) throws CategoryServiceException;

    List<Category> getAll() throws CategoryServiceException;

    void update(String categoryId, String name,
                String description, String imagePath) throws CategoryServiceException;


    void delete(String categoryId) throws CategoryServiceException;

    Category getById(String categoryId) throws CategoryServiceException;
}
