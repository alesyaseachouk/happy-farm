package com.solvd.happyfarm.animal;

import com.solvd.happyfarm.exception.InvalidVaccinationException;
import com.solvd.happyfarm.food.Food;
import com.solvd.happyfarm.product.Milk;

import java.util.Objects;

public class Cow extends Animal {

    private Milk milk;

    public Cow(float weight, boolean isVaccinated, int age, Food food) throws InvalidVaccinationException {
        super(weight, isVaccinated, age, food);
    }

    public Milk getMilk() {
        return milk;
    }

    public void setMilk(Milk milk) {
        this.milk = milk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cow)) return false;
        Cow cow = (Cow) o;
        return Objects.equals(getMilk(), cow.getMilk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMilk());
    }

    @Override
    public String toString() {
        return "Cow{" +
                "milk=" + milk +
                '}';
    }
}
