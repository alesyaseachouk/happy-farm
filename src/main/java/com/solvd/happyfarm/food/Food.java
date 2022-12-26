package com.solvd.happyfarm.food;

import com.solvd.happyfarm.price.Price;

public abstract class Food {

    private String name;
    private Double count;
    private Price price;

    public Food(String name, Double count, Price price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public Double annualNeeds(){
        Double annualNeeds = count * 365;
        return annualNeeds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
