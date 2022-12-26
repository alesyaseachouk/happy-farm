package com.solvd.happyfarm.product;

import com.solvd.happyfarm.price.Price;

import java.time.LocalDate;
import java.util.Objects;

public class Milk extends com.solvd.happyfarm.product.Product {

    private Double volume;

    public Milk(LocalDate manufactureDate, LocalDate expirationDate, Price price, Double volume) {
        super(manufactureDate, expirationDate, price);
        this.volume = volume;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Milk{" +
                "volume=" + volume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Milk)) return false;
        Milk milk = (Milk) o;
        return Objects.equals(getVolume(), milk.getVolume());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVolume());
    }
}
