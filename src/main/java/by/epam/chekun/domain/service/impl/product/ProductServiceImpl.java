package by.epam.chekun.domain.service.impl.product;

import by.epam.chekun.dao.ProductRepository;
import by.epam.chekun.dao.exception.product.ProductDAOException;
import by.epam.chekun.dao.manager.DAOManager;
import by.epam.chekun.domain.entity.product.Product;
import by.epam.chekun.domain.service.ProductService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.product.InvalidProductInformationException;
import by.epam.chekun.domain.service.exception.product.ProductServiceException;
import by.epam.chekun.domain.util.builder.product.impl.ProductBuilderImpl;
import by.epam.chekun.domain.util.manager.UtilManager;
import by.epam.chekun.domain.util.validator.product.ProductValidator;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository = DAOManager.getInstance().getProductRepository();
    private final ProductValidator productValidator = UtilManager.getInstance().getProductValidator();

    @Override
    public void add(String name, String description, String imagePath, String cost,
                    String categoryId, String brandId) throws ProductServiceException {

        if (!productValidator.validate(name, description, cost)) {
            throw new InvalidProductInformationException("Invalid product info");
        }


        final Product product = new ProductBuilderImpl()
                .withName(name)
                .withDescription(description)
                .withImagePath(imagePath)
                .withCost(Double.valueOf(cost))
                .build();

        try {
            productRepository.add(product);
            productRepository.addCategoryToProduct(product, categoryId);
            productRepository.addBrandToProduct(product, brandId);

        } catch (ProductDAOException e) {
            throw new ProductServiceException(e);
        }
    }


    @Override
    public List<Product> getAll() throws ProductServiceException {
        try {
            final List<Product> products = productRepository.getAll();
            return products;
        } catch (ProductDAOException e) {
            throw new ProductServiceException(e);
        }
    }


    @Override
    public void delete(String productId) throws ProductServiceException {
        try {
            productRepository.removeById(productId);
        } catch (ProductDAOException e) {
            throw new ProductServiceException(e);
        }
    }


    @Override
    public List<Product> getAllByCategory(String categoryId) throws ProductServiceException {
        try {
            final List<Product> products = productRepository.getAllByCategory(categoryId);
            return products;
        } catch (ProductDAOException e) {
            throw new ProductServiceException(e);
        }
    }

    @Override
    public List<Product> getAllByBrand(String brandId) throws ProductServiceException {
        try {
            final List<Product> products = productRepository.getAllByBrand(brandId);
            return products;
        } catch (ProductDAOException e) {
            throw new ProductServiceException(e);
        }
    }

    @Override
    public List<Product> getAllByCategoryAndBrand(String categoryId, String brandId) throws ProductServiceException {
        try {
            final List<Product> products = productRepository.getAllByCategoryAndBrand(categoryId, brandId);
            return products;
        } catch (ProductDAOException e) {
            throw new ProductServiceException(e);
        }
    }


    @Override
    public Product getById(String productId) throws ProductServiceException {
        try {
            return productRepository.getEntityById(productId);
        } catch (ProductDAOException e) {
            throw new ProductServiceException(e);
        }
    }


    @Override
    public void update(String productId, String name, String description,
                       String imagePath, String cost,
                       String categoryId, String brandId) throws ProductServiceException {
        if (!productValidator.validate(name, description, cost)) {
            throw new InvalidProductInformationException("Invalid product info");
        }

        final Product product = new ProductBuilderImpl(productId)
                .withName(name)
                .withDescription(description)
                .withImagePath(imagePath)
                .withCost(Double.valueOf(cost))
                .build();

        brandId = isParameterNull(brandId);
        categoryId = isParameterNull(categoryId);

        try {
            productRepository.update(product);
            productRepository.updateProductBrand(productId, brandId);
            productRepository.updateProductCategory(productId, categoryId);
        } catch (ProductDAOException e) {
            throw new ProductServiceException(e);
        }
    }

    private String isParameterNull(final String value) {
        return value == null ? null :
                value.equals("") ? null : value;
    }


    @Override
    public String getProductCategoryId(String productId) throws ProductServiceException {
        try {
            final Product product = productRepository.getEntityById(productId);
            return product.getCategory().getCategoryId();
        } catch (ProductDAOException e) {
            throw new ProductServiceException(e);
        }
    }

    @Override
    public String getProductBrandId(String productId) throws ProductServiceException {
        try {
            final Product product = productRepository.getEntityById(productId);
            return product.getBrand().getBrandId();
        } catch (ProductDAOException e) {
            throw new ProductServiceException(e);
        }
    }
}
