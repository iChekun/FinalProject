package by.epam.chekun.dao;

import by.epam.chekun.dao.exception.brand.BrandDAOException;
import by.epam.chekun.dao.initializer.CrudRepository;
import by.epam.chekun.domain.entity.brand.Brand;

import java.util.List;

public interface BrandRepository extends CrudRepository<Brand> {

    @Override
    Brand getEntityById(String id) throws BrandDAOException;

    @Override
    boolean removeById(String id) throws BrandDAOException;

    @Override
    boolean add(Brand brand) throws BrandDAOException;

    @Override
    boolean update(Brand brand) throws BrandDAOException;

    @Override
    List<Brand> getAll() throws BrandDAOException;
}
