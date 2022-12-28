package com.solvd.happyfarm.animal;

import com.solvd.happyfarm.food.Food;
import com.solvd.happyfarm.product.Wool;

public class Sheep extends Animal {

    private Wool wool;

    public Sheep(float weight, boolean isVaccinated, int age, Food food) {
        super(weight, isVaccinated, age, food);
    }

    public Wool getWool() {
        return wool;
    }

    public void setWool(Wool wool) {
        this.wool = wool;
    }
}
