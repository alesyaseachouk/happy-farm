package com.solvd.happyfarm;

import com.solvd.happyfarm.animal.Chicken;
import com.solvd.happyfarm.animal.Sheep;
import com.solvd.happyfarm.food.Corn;
import com.solvd.happyfarm.animal.Cow;
import com.solvd.happyfarm.food.Hay;
import com.solvd.happyfarm.food.Kombikorm;
import com.solvd.happyfarm.price.Price;
import com.solvd.happyfarm.product.Egg;
import com.solvd.happyfarm.product.Milk;
import com.solvd.happyfarm.product.Wool;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static com.solvd.happyfarm.FarmUtils.annualCostEggs;
import static com.solvd.happyfarm.FarmUtils.annualCostMilk;

public class Main {

    public static void main(String[] args) {

        Price priceCorn = new Price(BigDecimal.valueOf(0.5), "BYN");
        Price priceHay = new Price(BigDecimal.valueOf(0.1), "BYN");
        Price priceKombikorm = new Price(BigDecimal.valueOf(0.2), "BYN");
        Price priceEgg = new Price(BigDecimal.valueOf(0.2), "BYN");
        Price priceMilk = new Price(BigDecimal.valueOf(0.5), "BYN");
        Price priceWool = new Price(BigDecimal.valueOf(0.3), "BYN");

        Corn corn = new Corn("Zarya",0.1, priceCorn);
        Hay hay = new Hay("Seno", 5.0, priceHay);
        Kombikorm kombikorm = new Kombikorm("Petya",2.0, priceKombikorm);
        Kombikorm kombikorm1 = new Kombikorm("Borka", 1.0, priceKombikorm);

        Egg egg1 = new Egg(LocalDate.of(2022,01,22),LocalDate.of(2022,02,22), priceEgg, "D", 2);
        Egg egg2 = new Egg(LocalDate.of(2022,01,22),LocalDate.of(2022,02,22), priceEgg, "C", 1);

        Chicken chicken1 = new Chicken(3, true,1, corn);
        Chicken chicken2 = new Chicken(2, true,1, corn);
        Chicken chicken3 = new Chicken(3, true,2, corn);

        chicken1.setEgg(egg1);
        chicken2.setEgg(egg2);
        chicken3.setEgg(egg1);

        List<Chicken> chickens = new ArrayList<>();

        chickens.add(chicken1);
        chickens.add(chicken2);
        chickens.add(chicken3);

        annualCostEggs(chickens);

        Milk milk = new Milk(LocalDate.of(2022,01, 22), LocalDate.of(2022,02,01),priceMilk, 1.0);

        Wool wool = new Wool(LocalDate.of(2022,01, 22), LocalDate.of(2022,02,01),priceWool, 1.0f);

        Cow cow1 = new Cow(100, true, 1, hay);
        Cow  cow2 = new Cow(102, true, 2, hay);
        Cow  cow3 = new Cow(90, true, 1, hay);

        Set<Cow> cows = new HashSet<>();
        cows.add(cow1);
        cows.add(cow2);
        cows.add(cow3);
        cows.add(cow1);

        cows.forEach(cow -> cow.setMilk(milk));

        annualCostMilk(cows);

        Sheep sheep1 = new Sheep(67, true, 2, kombikorm);
        Sheep sheep2 = new Sheep(85, true, 2, kombikorm);
        Sheep sheep3 = new Sheep(94, true, 3, kombikorm);

        Map<String, Kombikorm> map = new HashMap<>();
        map.put("Kombikorm1", kombikorm );
        map.put("Kombikorm2", kombikorm1);

        List<Sheep> sheeps = new ArrayList<>();

        sheeps.add(sheep1);
        sheeps.add(sheep2);
        sheeps.add(sheep3);

        sheeps.forEach(sheep -> sheep.setWool(wool));







//         добавляю в лист куриц
//        создаю коров +лист set or map + овцы

        corn.annualNeeds();



//        Scanner sc = new Scanner(System.in);
//        System.out.println("Budget:");
//
//        int number = sc.nextInt();
//
//        System.out.println("Budget:" + number);
//
//        sc.close();

    }
}
