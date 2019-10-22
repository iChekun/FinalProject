package by.epam.chekun.domain.entity.brand;

import java.io.Serializable;
import java.util.Objects;

public class Brand implements Serializable {
    private static final long serialVersionUID = 1L;

    private String brandId;
    private String name;
    private String description;
    private String imagePath;

    public Brand() {
    }

    public Brand(String brandId, String name, String description, String imagePath) {
        this.brandId = brandId;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
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


    public void setBrandId(String brandId) {
        this.brandId = brandId;
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
        Brand brand = (Brand) o;
        return Objects.equals(brandId, brand.brandId) &&
                Objects.equals(name, brand.name) &&
                Objects.equals(description, brand.description) &&
                Objects.equals(imagePath, brand.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, name, description, imagePath);
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "brandId='" + brandId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
