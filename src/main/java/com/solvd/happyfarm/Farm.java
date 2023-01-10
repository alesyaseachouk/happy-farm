package com.solvd.happyfarm;

import com.solvd.happyfarm.animal.Chicken;
import com.solvd.happyfarm.animal.Cow;
import com.solvd.happyfarm.animal.Sheep;
import com.solvd.happyfarm.customer.Customer;
import com.solvd.happyfarm.product.Egg;
import com.solvd.happyfarm.product.Milk;
import com.solvd.happyfarm.product.Wool;
import java.util.List;
import java.util.Set;

public class Farm {

    private List<Chicken> chickens;
    private Set<Cow> cows;
    private List<Sheep> sheeps;
    private List<Customer> customers;
    private List<Egg> eggs;
    private List<Milk> milks;
    private List<Wool> wools;
    private int budget;

    public List<Chicken> getChickens() {
        return chickens;
    }

    public void setChickens(List<Chicken> chickens) {
        this.chickens = chickens;
    }

    public Set<Cow> getCows() {
        return cows;
    }

    public void setCows(Set<Cow> cows) {
        this.cows = cows;
    }

    public List<Sheep> getSheeps() {
        return sheeps;
    }

    public void setSheeps(List<Sheep> sheeps) {
        this.sheeps = sheeps;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Egg> getEggs() {
        return eggs;
    }

    public void setEggs(List<Egg> eggs) {
        this.eggs = eggs;
    }

    public List<Milk> getMilks() {
        return milks;
    }

    public void setMilks(List<Milk> milks) {
        this.milks = milks;
    }

    public List<Wool> getWools() {
        return wools;
    }

    public void setWools(List<Wool> wools) {
        this.wools = wools;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "chickens =" + chickens +
                '}';
    }
}
