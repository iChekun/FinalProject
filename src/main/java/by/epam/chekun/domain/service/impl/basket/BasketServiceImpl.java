package by.epam.chekun.domain.service.impl.basket;

import by.epam.chekun.dao.BasketRepository;
import by.epam.chekun.dao.exception.basket.BasketDAOException;
import by.epam.chekun.dao.manager.DAOManager;
import by.epam.chekun.domain.entity.basket.Basket;
import by.epam.chekun.domain.entity.basket.ProductBasket;
import by.epam.chekun.domain.entity.product.Product;
import by.epam.chekun.domain.service.BasketService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.basket.BasketServiceException;
import by.epam.chekun.domain.util.builder.basket.impl.BasketBuilderImpl;
import by.epam.chekun.domain.util.builder.basket.impl.ProductBasketBuilderImpl;
import by.epam.chekun.domain.util.builder.product.impl.ProductBuilderImpl;

import java.util.List;

public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository = DAOManager.getInstance().getBasketRepository();

    @Override
    public void createBasket(String userId) throws ServiceException {
        try {
            final Basket basket = new BasketBuilderImpl()
                    .withUserId(userId)
                    .build();

            basketRepository.add(basket);
        } catch (BasketDAOException e) {
            throw new BasketServiceException(e);
        }
    }


    @Override
    public Basket getBasket(String userId) throws ServiceException {
        try {
            final Basket basket = basketRepository.getEntityById(userId);
            return basket;
        } catch (BasketDAOException e) {
            throw new BasketServiceException(e);
        }
    }

    @Override
    public void addProductToBasket(String userId, String productId) throws ServiceException {

        final Basket basket = new BasketBuilderImpl()
                .withUserId(userId)
                .build();

        final Product product = new ProductBuilderImpl(productId).build();

        final ProductBasket productBasket = new ProductBasketBuilderImpl()
                .withBasket(basket)
                .withProduct(product)
                .build();

        try {
            basketRepository.addProductToBasket(productBasket);
        } catch (BasketDAOException e) {
            throw new BasketServiceException(e);
        }
    }


    @Override
    public void clearBasket(String basketId) throws ServiceException {
        try {
            basketRepository.clearBasket(basketId);
        } catch (BasketDAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<ProductBasket> getAllProductInBasket(String userId) throws ServiceException {

        try {
            final List<ProductBasket> productBaskets = basketRepository.getAllProductInBasket(userId);
            return productBaskets;
        } catch (BasketDAOException e) {
            throw new BasketServiceException(e);
        }
    }


    @Override
    public void deleteProductFromBasket(String basketId, String productId) throws ServiceException {
        try {
            final Basket basket = new BasketBuilderImpl(basketId).build();
            final Product product = new ProductBuilderImpl(productId).build();
            final ProductBasket productBasket = new ProductBasketBuilderImpl()
                    .withBasket(basket)
                    .withProduct(product)
                    .build();
            basketRepository.deleteProductFromBasket(productBasket);
        } catch (BasketDAOException e) {
            throw new BasketServiceException(e);
        }
    }


    @Override
    public double getCostOfProductsInBasket(String userId) throws ServiceException {
        try {
            double cost = basketRepository.getCostOfProductsInBasket(userId);
            return cost;
        } catch (BasketDAOException e) {
            throw new BasketServiceException(e);
        }
    }

    @Override
    public int getProductCountInBasket(String basketId) throws ServiceException {
        try {
            return basketRepository.getCountOfProductsInBasket(basketId);
        } catch (BasketDAOException e) {
            throw new BasketServiceException(e);
        }
    }
}
