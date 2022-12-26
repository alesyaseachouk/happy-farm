package com.solvd.happyfarm.product;

import com.solvd.happyfarm.price.Price;

import java.time.LocalDate;
import java.util.Objects;

public class Egg extends com.solvd.happyfarm.product.Product {

    private String category;
    private int size;

    public Egg(LocalDate manufactureDate, LocalDate expirationDate, Price price, String category, int size) {
        super( manufactureDate, expirationDate, price);
        this.category = category;
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public int getSize() {
        return size;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Egg{" +
                "category='" + category + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Egg)) return false;
        Egg egg = (Egg) o;
        return getSize() == egg.getSize() && Objects.equals(getCategory(), egg.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory(), getSize());
    }
}
