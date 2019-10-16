package by.epam.chekun.domain.util.builder.product;

import by.epam.chekun.domain.entity.category.Category;

public interface CategoryBuilder {

    CategoryBuilder withName(String name);

    CategoryBuilder withDescription(String description);

    CategoryBuilder withImagePath(String imagePath);

    Category build();
}
