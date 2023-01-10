package com.solvd.happyfarm;

import com.solvd.happyfarm.animal.Chicken;
import com.solvd.happyfarm.animal.Cow;
import com.solvd.happyfarm.animal.Sheep;
import com.solvd.happyfarm.exception.InvalidVaccinationException;
import com.solvd.happyfarm.food.Corn;
import com.solvd.happyfarm.food.Hay;
import com.solvd.happyfarm.food.Kombikorm;
import com.solvd.happyfarm.price.Price;
import com.solvd.happyfarm.product.Egg;
import com.solvd.happyfarm.product.Milk;
import com.solvd.happyfarm.product.Wool;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class FarmBuilder {

    public static List<Chicken> chickenBuilder(int chickenCount) throws InvalidVaccinationException {


        Price priceCorn = new Price(BigDecimal.valueOf(0.5), "BYN");
        Corn corn = new Corn("Zarya",0.1, priceCorn);
        Price priceEgg = new Price(BigDecimal.valueOf(0.2), "BYN");

        Egg egg1 = new Egg(LocalDate.of(2022,01,22),LocalDate.of(2022,02,22), priceEgg, "D", 2);
        Egg egg2 = new Egg(LocalDate.of(2022,01,22),LocalDate.of(2022,02,22), priceEgg, "C", 1);

        List<Chicken> chickens = new ArrayList<>();
        for (int i = 0; i < chickenCount; i++) {
            Chicken chicken= new Chicken(setRandomWeight(2.55f, 5.20f), true,setRandomAge(5), corn);
            if (i%2==0) {
                chicken.setEgg(egg1);
            } else { chicken.setEgg(egg2);}
            chickens.add(chicken);
        }
        return chickens;
    }

    public static Set<Cow> cowBuilder(int cowCount) throws InvalidVaccinationException {

        Price priceHay = new Price(BigDecimal.valueOf(0.1), "BYN");

        Hay hay = new Hay("Seno", 5.0, priceHay);

        Price priceMilk = new Price(BigDecimal.valueOf(0.5), "BYN");

        Milk milk1 = new Milk(LocalDate.of(2022,01, 22), LocalDate.of(2022,02,01),priceMilk, 1.0);
        Milk milk2 = new Milk(LocalDate.of(2022,01, 02), LocalDate.of(2022,02,11),priceMilk, 1.0);

        Set<Cow> cows = new HashSet<>();
        for (int i = 0; i < cowCount; i++) {
            Cow cow= new Cow(setRandomWeight(57.9f, 200.20f), true,setRandomAge(2), hay);
            if (i%2==0) {
                cow.setMilk(milk1);
            } else { cow.setMilk(milk2);}
            cows.add(cow);
        }
//        Cow cow1 = new Cow(100, true, 1, hay);
//        Cow cow2 = new Cow(102, true, 2, hay);
//        Cow cow3 = new Cow(90, true, 1, hay);
//
//        Set<Cow> cows = new HashSet<>();
//        cows.add(cow1);
//        cows.add(cow2);
//        cows.add(cow3);
//        cows.add(cow1);
//
//        cows.forEach(cow -> cow.setMilk(milk));

//        annualCostMilk(cows);

        return cows;
    }

    public static List<Sheep> sheepBuilder(int sheepCount) throws InvalidVaccinationException {
        Price priceKombikorm = new Price(BigDecimal.valueOf(0.2), "BYN");
        Price priceWool = new Price(BigDecimal.valueOf(0.3), "BYN");

        Kombikorm kombikorm = new Kombikorm("Petya",2.0, priceKombikorm);
        Kombikorm kombikorm1 = new Kombikorm("Borka", 1.0, priceKombikorm);

        Wool wool = new Wool(LocalDate.of(2022,01, 22), LocalDate.of(2022,02,01),priceWool, 1.0f);

        List<Sheep> sheeps = new ArrayList<>();
        for (int i = 0; i < sheepCount; i++) {
            Sheep sheep= new Sheep(setRandomWeight(7.55f, 25.20f), true,setRandomAge(5), kombikorm);
            sheep.setWool(wool);
            sheeps.add(sheep);
        }

        Sheep sheep1 = new Sheep(67, true, 2, kombikorm);
        Sheep sheep2 = new Sheep(85, true, 2, kombikorm);
        Sheep sheep3 = new Sheep(94, true, 3, kombikorm);

        Map<String, Kombikorm> map = new HashMap<>();
        map.put("Kombikorm1", kombikorm );
        map.put("Kombikorm2", kombikorm1);

//        List<Sheep> sheeps = new ArrayList<>();
//
//        sheeps.add(sheep1);
//        sheeps.add(sheep2);
//        sheeps.add(sheep3);
//        sheeps.forEach(sheep -> sheep.setWool(wool));
//
//        annualCostWool(sheeps);

        return sheeps;
    }

    public static float setRandomWeight(float min, float max) {
        Random r = new Random();
        float random = min + r.nextFloat() * (max - min);
        return random;
    }

    public static int  setRandomAge(int max)
    {
        int num = (int)(Math.random() *max);
        return num;
    }

    @Override
    public String toString() {
        return "FarmBuilder{}";
    }
}
