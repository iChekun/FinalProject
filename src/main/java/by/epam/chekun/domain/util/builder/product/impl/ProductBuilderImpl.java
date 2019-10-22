package by.epam.chekun.domain.util.builder.product.impl;

import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.entity.product.Product;
import by.epam.chekun.domain.util.builder.product.ProductBuilder;

public class ProductBuilderImpl implements ProductBuilder {

    private String productId;
    private Category category;
    private Brand brand;

    private String name;
    private String description;
    private String imagePath;
    private double cost;

    public ProductBuilderImpl() {
        this.productId = "";
    }

    public ProductBuilderImpl(String productId) {
        this.productId = productId;
    }

    @Override
    public ProductBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    @Override
    public ProductBuilder withBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ProductBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public ProductBuilder withImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    @Override
    public ProductBuilder withCost(double cost) {
        this.cost = cost;
        return this;
    }

    @Override
    public Product build() {
        final Product product = new Product();
        product.setProductId(productId);
        product.setCategory(category);
        product.setBrand(brand);
        product.setName(name);
        product.setDescription(description);
        product.setImagePath(imagePath);
        product.setCost(cost);
        return product;
    }

    public String getProductId() {
        return productId;
    }

    public Category getCategory() {
        return category;
    }

    public Brand getBrand() {
        return brand;
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

    public double getCost() {
        return cost;
    }
}
