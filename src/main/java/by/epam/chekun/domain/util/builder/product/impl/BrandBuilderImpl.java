package by.epam.chekun.domain.util.builder.product.impl;

import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.util.builder.product.BrandBuilder;

public class BrandBuilderImpl implements BrandBuilder {

    private String brandId;
    private String name;
    private String description;
    private String imagePath;


    public BrandBuilderImpl() {
        this.brandId = "";
    }

    public BrandBuilderImpl(String brandId) {
        this.brandId = brandId;
    }

    @Override
    public BrandBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public BrandBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public BrandBuilder withImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    @Override
    public Brand build() {
        final Brand brand = new Brand(brandId, name, description, imagePath);
        return brand;
    }


    public String getBrandId() {
        return brandId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }
}
