package com.solvd.happyfarm.animal;

import com.solvd.happyfarm.food.Food;

import java.math.BigDecimal;

public abstract class Animal {

    private float weight;
    private boolean isVaccinated;
    private int age;
    private Food food;

    public Animal(float weight, boolean isVaccinated, int age, Food food) {
        this.weight = weight;
        this.isVaccinated = isVaccinated;
        this.age = age;
        this.food = food;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}