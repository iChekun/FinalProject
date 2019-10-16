package by.epam.chekun.domain.util.builder.product;

import by.epam.chekun.domain.entity.brand.Brand;

public interface BrandBuilder {

    BrandBuilder withName(String name);

    BrandBuilder withDescription(String description);

    BrandBuilder withImagePath(String imagePath);

    Brand build();

}
