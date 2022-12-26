package com.solvd.happyfarm.customer;

public class Customer {

    private String name;
    private String country;
    private Boolean isRegularly;

    public Customer(String name, String country, Boolean isRegularly) {
        this.name = name;
        this.country = country;
        this.isRegularly = isRegularly;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Boolean getRegularly() {
        return isRegularly;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegularly(Boolean regularly) {
        isRegularly = regularly;
    }
}
