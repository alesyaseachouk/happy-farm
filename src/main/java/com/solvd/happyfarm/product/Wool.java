package com.solvd.happyfarm.product;

import com.solvd.happyfarm.price.Price;
import java.time.LocalDate;
import java.util.Objects;

public class Wool extends com.solvd.happyfarm.product.Product {

    private Float volume;

    public Wool(LocalDate manufactureDate, LocalDate expirationDate, Price price, Float volume) {
        super(manufactureDate, expirationDate, price);
        this.volume = volume;
    }

    public Float getWeight() {
        return volume;
    }

    public void setWeight(Float weight) {
        this.volume = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wool)) return false;
        Wool wool = (Wool) o;
        return Objects.equals(volume, wool.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume);
    }

    @Override
    public String toString() {
        return "Wool{" +
                "volume=" + volume +
                '}';
    }
}
