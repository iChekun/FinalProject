package by.epam.chekun.domain.util.builder.product;

import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.entity.product.Product;

public interface ProductBuilder {


    ProductBuilder withCategory(Category category);

    ProductBuilder withBrand(Brand brand);

    ProductBuilder withName(String name);

    ProductBuilder withDescription(String description);

    ProductBuilder withImagePath(String imagePath);

    ProductBuilder withCost(double cost);

    Product build();
}
