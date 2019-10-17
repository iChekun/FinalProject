package by.epam.chekun.domain.entity.basket;

import java.io.Serializable;
import java.util.Objects;

public class Basket implements Serializable {

    private String basketId;
    private String userId;


    public Basket() {
    }

    public Basket(String basketId, String userId) {
        this.basketId = basketId;
        this.userId = userId;
    }



    public String getBasketId() {
        return basketId;
    }

    public String getUserId() {
        return userId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(basketId, basket.basketId) &&
                Objects.equals(userId, basket.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basketId, userId);
    }
}
