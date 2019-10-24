package by.epam.chekun.dao.impl.product;

import by.epam.chekun.dao.InitializerRepository;
import by.epam.chekun.dao.ProductRepository;
import by.epam.chekun.dao.core.exception.JdbcTemplateException;
import by.epam.chekun.dao.exception.product.ProductCategoryDAOException;
import by.epam.chekun.dao.exception.product.ProductDAOException;

import by.epam.chekun.dao.mapper.ProductRowMapper;
import by.epam.chekun.domain.entity.product.Product;

import java.util.List;

import static by.epam.chekun.dao.impl.product.ProductSqlUtil.*;

public class ProductSqlRepository extends InitializerRepository implements ProductRepository {


    @Override
    public Product getEntityById(String id) throws ProductDAOException {
        try {
            final Product product = jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID, new ProductRowMapper(), id);
            return product;
        } catch (JdbcTemplateException e) {
            throw new ProductDAOException(e);
        }
    }

    @Override
    public boolean removeById(String id) throws ProductDAOException {
        try {
            jdbcTemplate.update(DELETE_PRODUCT_BY_ID, id);
            return true;
        } catch (JdbcTemplateException e) {
            throw new ProductDAOException(e);
        }
    }


    @Override
    public boolean add(Product product) throws ProductDAOException {
        try {
            jdbcTemplate.update(ADD_NEW_PRODUCT,
                    product.getName(),
                    product.getDescription(),
                    product.getImagePath(),
                    product.getCost());
            return true;
        } catch (JdbcTemplateException e) {
            throw new ProductDAOException(e);
        }
    }

    @Override
    public boolean update(Product product) throws ProductDAOException {
        try {
            jdbcTemplate.update(UPDATE_PRODUCT_BY_ID,
                    product.getName(),
                    product.getDescription(),
                    product.getImagePath(),
                    product.getCost(),
                    product.getProductId());
            return true;
        } catch (JdbcTemplateException e) {
            throw new ProductDAOException(e);
        }
    }

    @Override
    public List<Product> getAll() throws ProductDAOException {
        final List<Product> products = _getAll(GET_ALL_PRODUCTS);
        return products;
    }

    @Override
    public List<Product> getAllGroupByName() throws ProductDAOException {
        final List<Product> products = _getAll(GET_ALL_GROUP_BY_NAME);
        return products;
    }

    ///////////////////////////////////////////


    @Override
    public boolean addCategoryToProduct(Product product, String categoryId) throws ProductDAOException {
        return addCategoryOrBrandToProduct(product.getName(), categoryId,
                ADD_CATEGORY_TO_PRODUCT, ADD_NULL_CATEGORY_TO_PRODUCT);
    }

    @Override
    public boolean addBrandToProduct(Product product, String brandId) throws ProductDAOException {
        return addCategoryOrBrandToProduct(product.getName(), brandId,
                ADD_BRAND_TO_PRODUCT, ADD_NULL_BRAND_TO_PRODUCT);
    }

    private boolean addCategoryOrBrandToProduct(String productName,
                                                String positionId,
                                                String sql,
                                                String sqlWithNull) throws ProductCategoryDAOException {
        try {
            if (positionId != null) {
                jdbcTemplate.update(sql, productName, positionId);
            } else {
                jdbcTemplate.update(sqlWithNull, productName);
            }
            return true;
        } catch (JdbcTemplateException e) {
            throw new ProductCategoryDAOException(e);
        }
    }


    @Override
    public boolean updateProductCategory(String productId, String categoryId) throws ProductDAOException {
        try {
            jdbcTemplate.update(UPDATE_PRODUCT_CATEGORY, categoryId, productId);
            return true;
        } catch (JdbcTemplateException e) {
            throw new ProductCategoryDAOException(e);
        }
    }

    @Override
    public boolean updateProductBrand(String productId, String brandId) throws ProductDAOException {
        try {
            jdbcTemplate.update(UPDATE_PRODUCT_BRAND, brandId, productId);
            return true;
        } catch (JdbcTemplateException e) {
            throw new ProductCategoryDAOException(e);
        }
    }


    ///////////////////////////////////////////
    @Override
    public List<Product> getAllByCategory(String categoryId) throws ProductDAOException {
        final List<Product> products = _getAll(GET_ALL_WITH_CATEGORY, categoryId);
        return products;
    }

    @Override
    public List<Product> getAllByBrand(String brandId) throws ProductDAOException {
        final List<Product> products = _getAll(GET_ALL_WITH_BRAND, brandId);
        return products;
    }

    @Override
    public List<Product> getAllByCategoryAndBrand(String categoryId, String brandId) throws ProductDAOException {
        final List<Product> products = _getAll(GET_ALL_WITH_BRAND_AND_WITH_CATEGORY, categoryId, brandId);
        return products;
    }


    private List<Product> _getAll(final String sql, final Object... argc) throws ProductDAOException {
        try {
            final List<Product> products = jdbcTemplate.query(sql, new ProductRowMapper(), argc);
            return products;
        } catch (JdbcTemplateException e) {
            throw new ProductDAOException(e);
        }
    }

}
