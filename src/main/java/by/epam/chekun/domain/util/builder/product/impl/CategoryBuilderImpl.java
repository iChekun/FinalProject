package by.epam.chekun.domain.util.builder.product.impl;

import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.util.builder.product.CategoryBuilder;

public class CategoryBuilderImpl implements CategoryBuilder {
    private String categoryId;
    private String name;
    private String description;
    private String imagePath;


    public CategoryBuilderImpl() {
        this.categoryId = "";
    }

    public CategoryBuilderImpl(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public CategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public CategoryBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public CategoryBuilder withImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    @Override
    public Category build() {
        final Category category = new Category(categoryId, name, description, imagePath);
        return category;
    }
}
