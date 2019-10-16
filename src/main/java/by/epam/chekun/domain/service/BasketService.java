package by.epam.chekun.domain.service;

import by.epam.chekun.domain.entity.basket.Basket;
import by.epam.chekun.domain.entity.basket.ProductBasket;
import by.epam.chekun.domain.service.exception.ServiceException;

import java.util.List;

public interface BasketService {


    void createBasket(String userId) throws ServiceException;

    Basket getBasket(String userId) throws ServiceException;

    double getCostOfProductsInBasket(String userId) throws ServiceException;

    void clearBasket(String userId) throws ServiceException;

    ////////////////////////////////

    int getProductCountInBasket(String basketId) throws ServiceException;

    void addProductToBasket(String userId, String productId) throws ServiceException;

    List<ProductBasket> getAllProductInBasket(String userId) throws ServiceException;

    void deleteProductFromBasket(String basketId, String productId) throws ServiceException;

}
