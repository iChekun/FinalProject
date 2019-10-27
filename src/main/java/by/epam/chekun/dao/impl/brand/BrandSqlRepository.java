package by.epam.chekun.dao.impl.brand;

import by.epam.chekun.dao.BrandRepository;
import by.epam.chekun.dao.core.exception.JdbcTemplateException;
import by.epam.chekun.dao.exception.brand.BrandDAOException;
import by.epam.chekun.dao.exception.brand.UsedBrandNameDAOException;
import by.epam.chekun.dao.initializer.InitializerRepository;
import by.epam.chekun.dao.mapper.BrandRowMapper;
import by.epam.chekun.domain.entity.brand.Brand;

import java.util.List;

import static by.epam.chekun.dao.impl.brand.BrandSqlUtil.*;

public class BrandSqlRepository extends InitializerRepository implements BrandRepository {


    @Override
    public Brand getEntityById(String id) throws BrandDAOException {
        try {
            return jdbcTemplate.queryForObject(GET_BRAND_BY_ID,
                    new BrandRowMapper(), id);
        } catch (JdbcTemplateException e) {
            throw new BrandDAOException(e);
        }
    }

    @Override
    public boolean removeById(String id) throws BrandDAOException {
        try {
            jdbcTemplate.update(DELETE_BRAND_BY_ID, id);
            return true;
        } catch (JdbcTemplateException e) {
            throw new BrandDAOException(e);
        }
    }

    @Override
    public boolean add(Brand brand) throws BrandDAOException {

        try {
            if (isBrandNameUsed(brand.getName())) {
                throw new UsedBrandNameDAOException("name is already in use!");
            }

            jdbcTemplate.update(ADD_NEW_BRAND,
                    brand.getName(),
                    brand.getDescription(),
                    brand.getImagePath());

            return true;
        } catch (JdbcTemplateException e) {
            throw new BrandDAOException(e);
        }
    }

    @Override
    public boolean update(Brand brand) throws BrandDAOException {

        try {
            jdbcTemplate.update(UPDATE_BRAND,
                    brand.getName(),
                    brand.getDescription(),
                    brand.getImagePath(),
                    brand.getBrandId());

            return true;
        } catch (JdbcTemplateException e) {
            throw new BrandDAOException(e);
        }
    }

    @Override
    public List<Brand> getAll() throws BrandDAOException {

        try {
            return jdbcTemplate.query(GET_ALL_BRANDS, new BrandRowMapper());
        } catch (JdbcTemplateException e) {
            throw new BrandDAOException(e);
        }
    }


    private boolean isBrandNameUsed(String name) throws JdbcTemplateException {
        return jdbcTemplate.queryForObject(GET_BRAND_ID_BY_NAME, name);
    }
}
