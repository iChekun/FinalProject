package by.epam.chekun.dao;

import by.epam.chekun.dao.exception.product.ProductDAOException;
import by.epam.chekun.domain.entity.product.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product> {


    @Override
    Product getEntityById(String id) throws ProductDAOException;

    @Override
    boolean removeById(String id) throws ProductDAOException;

    @Override
    boolean add(Product product) throws ProductDAOException;

    @Override
    boolean update(Product product) throws ProductDAOException;

    @Override
    List<Product> getAll() throws ProductDAOException;

    boolean addCategoryToProduct(Product product, String categoryId) throws ProductDAOException;

    boolean addBrandToProduct(Product product, String brandId) throws ProductDAOException;

    boolean updateProductCategory(String productId, String categoryId) throws ProductDAOException;

    boolean updateProductBrand(String productId, String brandId) throws ProductDAOException;


    /*********************/
    List<Product> getAllGroupByName() throws ProductDAOException;

    List<Product> getAllByCategory(String categoryId) throws ProductDAOException;

    List<Product> getAllByBrand(String brandId) throws ProductDAOException;

    List<Product> getAllByCategoryAndBrand(String categoryId, String brandId) throws ProductDAOException;
}
