package by.epam.chekun.dao.impl.basket;

import by.epam.chekun.dao.BasketRepository;
import by.epam.chekun.dao.core.RowMapper;
import by.epam.chekun.dao.core.exception.JdbcTemplateException;
import by.epam.chekun.dao.exception.basket.BasketDAOException;
import by.epam.chekun.dao.initializer.InitializerRepository;
import by.epam.chekun.dao.mapper.BasketRowMapper;
import by.epam.chekun.dao.mapper.ProductBasketRowMapper;
import by.epam.chekun.domain.entity.basket.Basket;
import by.epam.chekun.domain.entity.basket.ProductBasket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static by.epam.chekun.dao.impl.basket.BasketSqlUtil.*;

public class BasketSqlRepository extends InitializerRepository implements BasketRepository {

    @Override
    public boolean add(Basket basket) throws BasketDAOException {
        try {
            jdbcTemplate.update(CREATE_BASKET, basket.getUserId());
            return false;
        } catch (JdbcTemplateException e) {
            throw new BasketDAOException(e);
        }
    }


    @Override
    public Basket getEntityById(String userId) throws BasketDAOException {
        try {
            return jdbcTemplate.queryForObject(GET_BASKET_BY_USER_ID,
                    new BasketRowMapper(), userId);
        } catch (JdbcTemplateException e) {
            throw new BasketDAOException(e);
        }
    }


    @Override
    public double getCostOfProductsInBasket(String userId) throws BasketDAOException {
        try {
            return jdbcTemplate.queryForObject(GET_COST_OF_PRODUCTS_IN_BASKET,
                    new RowMapper<Double>() {
                        @Override
                        public Double mapRow(ResultSet set) throws SQLException {
                            return set.getDouble(1);
                        }
                    },
                    userId);
        } catch (JdbcTemplateException e) {
            throw new BasketDAOException(e);
        }

    }


    @Override
    public boolean clearBasket(String basketId) throws BasketDAOException {
        try {
            jdbcTemplate.update(DELETE_ALL_PRODUCTS_FROM_BASKET, basketId);
            return true;
        } catch (JdbcTemplateException e) {
            throw new BasketDAOException(e);
        }
    }

    @Override
    public boolean addProductToBasket(ProductBasket productBasket) throws BasketDAOException {
        try {
            jdbcTemplate.update(ADD_PRODUCT_TO_BASKET,
                    productBasket.getBasket().getUserId(),
                    productBasket.getProduct().getProductId());
            return true;
        } catch (JdbcTemplateException e) {
            throw new BasketDAOException(e);
        }
    }

    @Override
    public boolean deleteProductFromBasket(ProductBasket productBasket) throws BasketDAOException {
        try {
            jdbcTemplate.update(DELETE_PRODUCT_FROM_BASKET,
                    productBasket.getBasket().getBasketId(),
                    productBasket.getProduct().getProductId());
            return true;
        } catch (JdbcTemplateException e) {
            throw new BasketDAOException(e);
        }
    }

    @Override
    public List<ProductBasket> getAllProductInBasket(String userId) throws BasketDAOException {
        try {
            return jdbcTemplate.query(GET_ALL_PRODUCTS_IN_BASKET,
                    new ProductBasketRowMapper(), userId);
        } catch (JdbcTemplateException e) {
            throw new BasketDAOException(e);
        }
    }


    @Override
    public int getCountOfProductsInBasket(String basketId) throws BasketDAOException {
        try {
            return jdbcTemplate.queryForObject(GET_COUNT_OF_PRODUCTS_IN_USER_BASKET
                    , new RowMapper<Integer>() {

                        @Override
                        public Integer mapRow(ResultSet set) throws SQLException {
                            return set.getInt(1);
                        }
                    }, basketId);
        } catch (JdbcTemplateException e) {
            throw new BasketDAOException(e);
        }
    }


    @Override
    public boolean removeById(String userI) throws BasketDAOException {
        throw new UnsupportedOperationException("can`t remove basket!");
    }

    @Override
    public boolean update(Basket basket) throws BasketDAOException {
        throw new UnsupportedOperationException("can`t update basket!");
    }

    @Override
    public List<Basket> getAll() throws BasketDAOException {
        throw new UnsupportedOperationException("can`t get all baskets!");
    }

}
