package com.solvd.happyfarm.food;

import com.solvd.happyfarm.price.Price;

public class Kombikorm extends Food {

    public Kombikorm(String name, Double count, Price price) {
        super(name, count, price);
    }

    @Override
    public String toString() {
        return "Kombikorm{}";
    }
}
