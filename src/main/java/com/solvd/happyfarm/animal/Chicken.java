package com.solvd.happyfarm.animal;

import com.solvd.happyfarm.exception.InvalidVaccinationException;
import com.solvd.happyfarm.product.Egg;
import com.solvd.happyfarm.food.Food;

import java.util.Objects;

public class Chicken extends Animal {

    private Egg egg;


    public Chicken(float weight, boolean isVaccinated, int age, Food food) throws InvalidVaccinationException {
        super(weight, isVaccinated, age, food);
    }

    public Chicken(float weight, boolean isVaccinated, int age, Food food, Egg egg) throws InvalidVaccinationException {
        super(weight, isVaccinated, age, food);
        this.egg = egg;
    }

    public void deleteEgg (){
        this.egg=null;
    }

    public Egg getEgg() {
        return egg;
    }

    public void setEgg(Egg egg) {
        this.egg = egg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chicken)) return false;
        Chicken chicken = (Chicken) o;
        return Objects.equals(getEgg(), chicken.getEgg());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEgg());
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "egg=" + egg +
                '}';
    }
}
