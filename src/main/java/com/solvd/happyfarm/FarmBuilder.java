package com.solvd.happyfarm;

import com.solvd.happyfarm.animal.Chicken;
import com.solvd.happyfarm.animal.Cow;
import com.solvd.happyfarm.animal.Sheep;
import com.solvd.happyfarm.customer.Customer;
import com.solvd.happyfarm.exception.InvalidVaccinationException;
import com.solvd.happyfarm.food.Corn;
import com.solvd.happyfarm.food.Hay;
import com.solvd.happyfarm.food.Kombikorm;
import com.solvd.happyfarm.price.Price;
import com.solvd.happyfarm.product.CategoryEgg;
import com.solvd.happyfarm.product.Egg;
import com.solvd.happyfarm.product.Milk;
import com.solvd.happyfarm.product.Wool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static com.solvd.happyfarm.Main.CURRENCY;

public class FarmBuilder {

    private static final Logger LOGGER = LogManager.getLogger(FarmBuilder.class);

    public static List<Chicken> chickenBuilder(Scanner sc) throws InvalidVaccinationException {

        LOGGER.info("Enter Chickens Count: ");
        int chickenCount = sc.nextInt();

        Price priceCorn = new Price( 0.5, "BYN");
        Corn corn = new Corn("Zarya",0.1, priceCorn);
        Price priceEgg = new Price(0.2, "BYN");

        Egg egg1 = new Egg(LocalDate.of(2022,01,22),LocalDate.of(2022,02,22), priceEgg, CategoryEgg.D, 2);
        Egg egg2 = new Egg(LocalDate.of(2022,01,22),LocalDate.of(2022,02,22), priceEgg, CategoryEgg.C, 1);

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

//    public static List<Egg> countEggsDay(List<Chicken> chickens) {
//
//        Price priceEgg = new Price(BigDecimal.valueOf(0.2), "BYN");
//        Egg egg1 = new Egg(LocalDate.of(2022,01,22),LocalDate.of(2022,02,22), priceEgg, CategoryEgg.D, 2);
//        Egg egg2 = new Egg(LocalDate.of(2022,01,22),LocalDate.of(2022,02,22), priceEgg, CategoryEgg.C, 1);
//        Price priceEgg1 = new Price(BigDecimal.valueOf(5.5), "BYN");
//        List<Egg> eggs = new ArrayList<>();
//        eggs.add(egg1);
//        eggs.add(egg2);
//
//        int eggsDay = chickens.get(0).getEgg().getSize()* chickens.size();
//
//        return eggs;
//    }

    public static List<Cow> cowBuilder(Scanner sc) throws InvalidVaccinationException {

        LOGGER.info("Enter Cows Count: ");
        int cowCount = sc.nextInt();
        Price priceHay = new Price(0.1, "BYN");
        Hay hay = new Hay("Seno", 5.0, priceHay);
        Price priceMilk = new Price(0.5, "BYN");
        Milk milk1 = new Milk(LocalDate.of(2022,01, 22), LocalDate.of(2022,02,01),priceMilk, 4.5);
        Milk milk2 = new Milk(LocalDate.of(2022,01, 02), LocalDate.of(2022,02,11),priceMilk, 1.0);

        List<Cow> cows = new ArrayList<>();
        for (int i = 0; i < cowCount; i++) {
            Cow cow= new Cow(setRandomWeight(57.9f, 200.20f), true,setRandomAge(2), hay);
            if (i%2==0) {
                cow.setMilk(milk1);
            } else { cow.setMilk(milk1);}
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
//        cows.forEach(cow -> cow.setMilk(milk1));

//        annualCostMilk(cows);

        return cows;
    }

    public static Milk countMilkDay(List<Cow> cows, double price) {
        double volumeMilkDay = cows.stream().mapToDouble( x-> x.getMilk().getVolume()).sum();
        Price priceMilk = new Price(price, CURRENCY);
        Milk milk = new Milk(LocalDate.now(), LocalDate.of(2022,02,01),priceMilk, volumeMilkDay);
        return milk;
    }

    public static List<Sheep> sheepBuilder(Scanner sc) throws InvalidVaccinationException {

        LOGGER.info("Enter Sheep Count: ");
        int sheepCount = sc.nextInt();

        Price priceKombikorm = new Price(0.2, CURRENCY);
        Price priceWool = new Price(0.3, CURRENCY);

        Kombikorm kombikorm = new Kombikorm("Petya",2.0, priceKombikorm);
        Kombikorm kombikorm1 = new Kombikorm("Borka", 1.0, priceKombikorm);

        Wool wool = new Wool(LocalDate.of(2022,01, 22), LocalDate.of(2022,02,01),priceWool, 1.0f);

        List<Sheep> sheeps = new ArrayList<>();
        for (int i = 0; i < sheepCount; i++) {
            Sheep sheep= new Sheep(setRandomWeight(7.55f, 25.20f), true,setRandomAge(5), kombikorm);
            sheep.setWool(wool);
            sheeps.add(sheep);
        }

//        Sheep sheep1 = new Sheep(67, true, 2, kombikorm);
//        Sheep sheep2 = new Sheep(85, true, 2, kombikorm);
//        Sheep sheep3 = new Sheep(94, true, 3, kombikorm);
//
//        Map<String, Kombikorm> map = new HashMap<>();
//        map.put("Kombikorm1", kombikorm );
//        map.put("Kombikorm2", kombikorm1);

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

    public static Wool countWoolDay(List<Sheep> sheep) {
        double volumeWoolDay = sheep.get(0).getWool().getVolume()*sheep.size();
        Price priceWool = new Price(0.3, CURRENCY);
        Wool wool = new Wool(LocalDate.now(), LocalDate.of(2023,02,01), priceWool, (float) volumeWoolDay);
        return wool;
    }

    public static float setRandomWeight(float min, float max) {
        Random r = new Random();
        float random = min + r.nextFloat() * (max - min);
        return random;
    }

    public static int  setRandomAge(int max)
    {
        int num = (int)(Math.random()*max);
        return num;
    }

    public static List<Customer> customerBuilder (Scanner sc){

        LOGGER.info("Customer for today: ");
        int customerCount =  sc.nextInt();

        List<Customer> customers= new ArrayList<>();
        for (int i=0; i<customerCount; i++){
            Customer customer = new Customer();
            LOGGER.info("Enter your name, please: ");
            String customerName = sc.next();
            customer.setName(customerName);
            LOGGER.info("Where are you from: ");
            String customerCountry = sc.next();
            customer.setCountry(customerCountry);
            LOGGER.info("Are you regularly (Y or N): ");
            String isRegularly = sc.next();
            if (isRegularly.equals("Y")) {
                customer.setRegularly(true);
            } else {
                customer.setRegularly(false);
            }
            customers.add(customer);
        }
        return customers;
    }

    public static double budgetBuilder (Scanner sc){
        LOGGER.info("Enter budget: ");
        return sc.nextInt();
    }

    @Override
    public String toString() {
        return "FarmBuilder{}";
    }
}
