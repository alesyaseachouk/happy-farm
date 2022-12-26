package com.solvd.happyfarm.animal;

import com.solvd.happyfarm.food.Food;
import com.solvd.happyfarm.product.Milk;

public class Cow extends Animal {

    private Milk milk;

    public Cow(float weight, boolean isVaccinated, int age, Food food) {
        super(weight, isVaccinated, age, food);
    }

    public Milk getMilk() {
        return milk;
    }

    public void setMilk(Milk milk) {
        this.milk = milk;
    }
}
