package by.epam.chekun.domain.service;

import by.epam.chekun.domain.entity.basket.Basket;
import by.epam.chekun.domain.entity.basket.ProductBasket;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.basket.BasketServiceException;

import java.util.List;

public interface BasketService {


    void createBasket(String userId) throws BasketServiceException;

    Basket getBasket(String userId) throws BasketServiceException;

    double getCostOfProductsInBasket(String userId) throws BasketServiceException;

    void clearBasket(String userId) throws BasketServiceException;

    ////////////////////////////////

    int getProductCountInBasket(String basketId) throws BasketServiceException;

    void addProductToBasket(String userId, String productId) throws BasketServiceException;

    List<ProductBasket> getAllProductInBasket(String userId) throws BasketServiceException;

    void deleteProductFromBasket(String basketId, String productId) throws BasketServiceException;

}
