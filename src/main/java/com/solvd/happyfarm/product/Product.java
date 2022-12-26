package com.solvd.happyfarm.product;

import com.solvd.happyfarm.price.Price;

import java.time.LocalDate;

public abstract class Product {

    private LocalDate manufactureDate;
    private LocalDate expirationDate;
    private Price price;

    public Product(LocalDate manufactureDate, LocalDate expirationDate, Price price) {
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Price getPrice() {
        return price;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
