package com.solvd.happyfarm.animal;

import com.solvd.happyfarm.exception.InvalidVaccinationException;
import com.solvd.happyfarm.food.Food;

public abstract class Animal {

    private float weight;
    private boolean isVaccinated;
    private int age;
    private Food food;

    public Animal(float weight, boolean isVaccinated, int age, Food food) throws InvalidVaccinationException {
        this.weight = weight;
        this.isVaccinated = isVaccinated;
        if(!isVaccinated){
            throw new InvalidVaccinationException("This animal should be vaccinated. Please change data");
        }
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