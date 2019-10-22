package by.epam.chekun.domain.entity.category;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    private String categoryId;
    private String name;
    private String description;
    private String imagePath;

    public Category() {
    }

    public Category(String categoryId, String name, String description, String imagePath) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getCategoryId() {
        return categoryId;
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

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) &&
                Objects.equals(name, category.name) &&
                Objects.equals(description, category.description) &&
                Objects.equals(imagePath, category.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, description, imagePath);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "categoryId='" + categoryId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
