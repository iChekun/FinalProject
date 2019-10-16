package by.epam.chekun.domain.entity.product;

import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.entity.category.Category;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

    private String productId;
    private Category category;
    private Brand brand;

    private String name;
    private String description;
    private String imagePath;
    private double cost;


    public Product() {
    }

    public Product(String productId, Category category, Brand brand,
                   String name, String description, String imagePath, double cost) {
        this.productId = productId;
        this.category = category;
        this.brand = brand;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.cost = cost;
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


    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.cost, cost) == 0 &&
                Objects.equals(productId, product.productId) &&
                Objects.equals(category, product.category) &&
                Objects.equals(brand, product.brand) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(imagePath, product.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, category, brand, name, description, imagePath, cost);
    }
}
