package com.solvd.happyfarm.product;

import com.solvd.happyfarm.price.Price;
import java.time.LocalDate;

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
}
