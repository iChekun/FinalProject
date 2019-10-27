package by.epam.chekun.dao;

import by.epam.chekun.dao.exception.basket.BasketDAOException;
import by.epam.chekun.dao.initializer.CrudRepository;
import by.epam.chekun.domain.entity.basket.Basket;
import by.epam.chekun.domain.entity.basket.ProductBasket;

import java.util.List;

public interface BasketRepository extends CrudRepository<Basket> {

    @Override
    Basket getEntityById(String userId) throws BasketDAOException;

    @Override
    boolean add(Basket basket) throws BasketDAOException;

    @Override
    List<Basket> getAll() throws BasketDAOException;

    ///////////////////////////////////////////////////////////////////

    double getCostOfProductsInBasket(String userId) throws BasketDAOException;

    boolean clearBasket(String userId) throws BasketDAOException;

    ///////////////////////////////////////////////////////////////////

    int getCountOfProductsInBasket(String basketId) throws BasketDAOException;

    boolean addProductToBasket(ProductBasket productBasket) throws BasketDAOException;

    boolean deleteProductFromBasket(ProductBasket productBasket) throws BasketDAOException;

    List<ProductBasket> getAllProductInBasket(String userId) throws BasketDAOException;

    ///////////////////////////////////////////////////////////////////

}
