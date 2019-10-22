package by.epam.chekun.domain.service;

import by.epam.chekun.domain.entity.product.Product;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.product.ProductServiceException;

import java.util.List;

public interface ProductService {

    void add(String name, String description, String imagePath, String cost,
             String categoryId, String brandId) throws ProductServiceException;

    List<Product> getAll() throws ProductServiceException;

    void delete(String productId) throws ProductServiceException;

    Product getById(String productId) throws ProductServiceException;

    void update(String productId, String name, String description, String imagePath, String cost,
                String categoryId, String brandId) throws ProductServiceException;

    /////////////////////////////////////////////////////

    String getProductCategoryId(String productId) throws ProductServiceException;

    String getProductBrandId(String productId) throws ProductServiceException;
    /////////////////////////////////////////////////////

    List<Product> getAllByCategory(String categoryId) throws ProductServiceException;

    List<Product> getAllByBrand(String brandId) throws ProductServiceException;

    List<Product> getAllByCategoryAndBrand(String categoryId, String brandId) throws ProductServiceException;

}
