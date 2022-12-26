package com.solvd.happyfarm.animal;

import com.solvd.happyfarm.product.Egg;
import com.solvd.happyfarm.food.Food;

public class Chicken extends Animal {

    private Egg egg;

    public Chicken(float weight, boolean isVaccinated, int age, Food food) {
        super(weight, isVaccinated, age, food);
    }

    public Egg getEgg() {
        return egg;
    }

    public void setEgg(Egg egg) {
        this.egg = egg;
    }
}
