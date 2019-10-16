package by.epam.chekun.domain.service;

import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.service.exception.ServiceException;

import java.util.List;

public interface BrandService {
    void add(String name, String description, String imagePath) throws ServiceException;

    List<Brand> getAll() throws ServiceException;

    void update(String brandId, String name,
                String description, String imagePath) throws ServiceException;

    void delete(String brandId) throws ServiceException;

    Brand getById(String brandId) throws ServiceException;
}
