package by.epam.chekun.domain.entity.basket;

import by.epam.chekun.domain.entity.product.Product;

import java.io.Serializable;
import java.util.Objects;

public class ProductBasket implements Serializable {
    private Basket basket;
    private Product product;

    public ProductBasket() {
    }

    public ProductBasket(Basket basket, Product product) {
        this.basket = basket;
        this.product = product;
    }

    public Basket getBasket() {
        return basket;
    }

    public Product getProduct() {
        return product;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket that = (ProductBasket) o;
        return Objects.equals(basket, that.basket) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basket, product);
    }
}
