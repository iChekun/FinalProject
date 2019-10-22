package by.epam.chekun.domain.service;

import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.brand.BrandServiceException;

import java.util.List;

public interface BrandService {
    void add(String name, String description, String imagePath) throws BrandServiceException;

    List<Brand> getAll() throws BrandServiceException;

    void update(String brandId, String name,
                String description, String imagePath) throws BrandServiceException;

    void delete(String brandId) throws BrandServiceException;

    Brand getById(String brandId) throws BrandServiceException;
}
