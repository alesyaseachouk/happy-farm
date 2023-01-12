package com.solvd.happyfarm.customer;

import java.util.Objects;

public class Customer {

    private String name;
    private String country;
    private boolean isRegularly;

    public Customer() {
    }

    public Customer(String name, boolean isRegularly) {
        this.name = name;
        this.isRegularly = isRegularly;
    }

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

    public boolean getRegularly() {
        return isRegularly;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegularly(boolean regularly) {
        isRegularly = regularly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getName(), customer.getName()) && Objects.equals(getCountry(), customer.getCountry()) && Objects.equals(isRegularly, customer.isRegularly);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCountry(), isRegularly);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", isRegularly=" + isRegularly +
                '}';
    }
}
