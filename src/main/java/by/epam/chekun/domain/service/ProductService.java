package by.epam.chekun.domain.service;

import by.epam.chekun.domain.entity.product.Product;
import by.epam.chekun.domain.service.exception.ServiceException;

import java.util.List;

public interface ProductService {

    void add(String name, String description, String imagePath, String cost,
             String categoryId, String brandId) throws ServiceException;

    List<Product> getAll() throws ServiceException;

    void delete(String productId) throws ServiceException;

    Product getById(String productId) throws ServiceException;

    void update(String productId, String name, String description, String imagePath, String cost,
                String categoryId, String brandId) throws ServiceException;

    /////////////////////////////////////////////////////

    String getProductCategoryId(String productId) throws ServiceException;

    String getProductBrandId(String productId) throws ServiceException;
    /////////////////////////////////////////////////////

    List<Product> getAllByCategory(String categoryId) throws ServiceException;

    List<Product> getAllByBrand(String brandId) throws ServiceException;

    List<Product> getAllByCategoryAndBrand(String categoryId, String brandId) throws ServiceException;

}
