package com.solvd.happyfarm;

import com.solvd.happyfarm.animal.Chicken;
import com.solvd.happyfarm.animal.Cow;
import com.solvd.happyfarm.animal.Sheep;
import com.solvd.happyfarm.customer.Customer;
import com.solvd.happyfarm.product.Egg;
import com.solvd.happyfarm.product.Wool;
import java.util.List;

public class Farm {

    private List<Chicken> chickens;
    private List<Cow> cows;
    private List<Sheep> sheeps;
    private List<Customer> customers;
    private List<Egg> eggs;
    private double milk;
    private double wool;
    private int budget;

    public Farm() {
    }

    public Farm(List<Chicken> chickens, List<Egg> eggs, List<Cow> cows, List<Sheep> sheeps, double milk, double wool ) {
        this.chickens = chickens;
        this.eggs = eggs;
        this.cows = cows;
        this.sheeps = sheeps;
        this.milk = milk;
        this.wool = wool;
    }

    public List<Chicken> getChickens() {
        return chickens;
    }

    public void setChickens(List<Chicken> chickens) {
        this.chickens = chickens;
    }

    public List<Cow> getCows() {
        return cows;
    }

    public void setCows(List<Cow> cows) {
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

    public Double getMilk() {
        return milk;
    }

    public void setMilk(Double milk) {
        this.milk = milk;
    }

    public double getWools() {
        return wool;
    }

    public void setWools(Wool wools) {
        this.wool = wool;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String toString() {
        return "Farm info: \n" +
                " \n chickens = " + chickens +
        "\n cows =" + cows +
                "\n sheep =" + sheeps +
                "\n Products created each day: " +
                "\n eggs =" + eggs +
                "\n milk =" + milk +
        "wool =" + wool;
        }
}
