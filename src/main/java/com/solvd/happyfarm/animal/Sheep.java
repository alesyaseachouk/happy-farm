package com.solvd.happyfarm.animal;

import com.solvd.happyfarm.exception.InvalidVaccinationException;
import com.solvd.happyfarm.food.Food;
import com.solvd.happyfarm.product.Wool;
import java.util.Objects;

public class Sheep extends Animal {

    private Wool wool;

    public Sheep(float weight, boolean isVaccinated, int age, Food food) throws InvalidVaccinationException {
        super(weight, isVaccinated, age, food);
    }

    public void deleteWool (){
        this.wool=null;
    }

    public Wool getWool() {
        return wool;
    }

    public void setWool(Wool wool) {
        this.wool = wool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sheep)) return false;
        Sheep sheep = (Sheep) o;
        return Objects.equals(getWool(), sheep.getWool());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWool());
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "wool=" + wool +
                '}';
    }
}
