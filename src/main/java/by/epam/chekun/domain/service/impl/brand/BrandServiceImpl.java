package by.epam.chekun.domain.service.impl.brand;

import by.epam.chekun.dao.BrandRepository;
import by.epam.chekun.dao.exception.brand.BrandDAOException;
import by.epam.chekun.dao.exception.brand.UsedBrandNameDAOException;
import by.epam.chekun.dao.manager.DAOManager;
import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.service.BrandService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.brand.BrandServiceException;
import by.epam.chekun.domain.service.exception.brand.InvalidBrandInformationException;
import by.epam.chekun.domain.service.exception.brand.UsedBrandNameServiceException;
import by.epam.chekun.domain.util.builder.product.impl.BrandBuilderImpl;
import by.epam.chekun.domain.util.manager.UtilManager;
import by.epam.chekun.domain.util.validator.brand.BrandValidator;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository = DAOManager.getInstance().getBrandRepository();
    private final BrandValidator brandValidator = UtilManager.getInstance().getBrandValidator();

    @Override
    public void add(String name, String description, String imagePath) throws ServiceException {
        if (!brandValidator.validate(name, description)) {
            throw new InvalidBrandInformationException("Invalid info!");
        }

        final Brand brand = new BrandBuilderImpl()
                .withName(name)
                .withDescription(description)
                .withImagePath(imagePath)
                .build();

        try {
            brandRepository.add(brand);
        } catch (UsedBrandNameDAOException e) {
            throw new UsedBrandNameServiceException(e);
        } catch (BrandDAOException e) {
            throw new BrandServiceException(e);
        }
    }

    @Override
    public List<Brand> getAll() throws ServiceException {
        try {
            final List<Brand> brands = brandRepository.getAll();
            return brands;
        } catch (BrandDAOException e) {
            throw new BrandServiceException(e);
        }
    }

    @Override
    public void update(String brandId, String name,
                       String description, String imagePath) throws ServiceException {
        try {

            Brand brand = new BrandBuilderImpl(brandId)
                    .withName(name)
                    .withDescription(description)
                    .withImagePath(imagePath)
                    .build();

            brandRepository.update(brand);
        } catch (BrandDAOException e) {
            throw new ServiceException(e);
        }
    }


    @Override
    public Brand getById(String brandId) throws ServiceException {
        try {
            final Brand brand = brandRepository.getEntityById(brandId);
            return brand;
        } catch (BrandDAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(String brandId) throws ServiceException {
        try {
            brandRepository.removeById(brandId);
        } catch (BrandDAOException e) {
            throw new ServiceException(e);
        }
    }
}
