package com.solvd.happyfarm;

import com.solvd.happyfarm.animal.Chicken;
import com.solvd.happyfarm.customer.Customer;
import com.solvd.happyfarm.exception.InvalidVaccinationException;
import com.solvd.happyfarm.product.Egg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.stream.Collectors;

import static com.solvd.happyfarm.FarmBuilder.*;
import static com.solvd.happyfarm.FarmUtils.*;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public final static String CURRENCY = "BYN";

    public static void main(String[] args) throws InvalidVaccinationException {

        Farm farm = new Farm();
        Scanner sc = new Scanner(System.in);

        farm.setBudget(budgetBuilder(sc));
        farm.setChickens(chickenBuilder(sc));
        farm.setCows(cowBuilder(sc));
        farm.setSheeps(sheepBuilder(sc));
        farm.setMilk(countMilkDay(farm.getCows()));
        farm.setWool(countWoolDay(farm.getSheeps()));

        List<Egg> eggs = farm.getChickens().stream()
                .map(Chicken::getEgg)
                .collect(Collectors.toList());
        farm.setEggs(eggs);

        LOGGER.info("All farm animals: \n " + farm);

        List<Customer> customers = customerBuilder(sc);
        farm.setCustomers(customers);

        LOGGER.info(farm);

        List<Customer> regularlyCustomers = customers.stream()
                .filter(Customer::getRegularly)
                .collect(Collectors.toList());

        LOGGER.info("Hello, "+ regularlyCustomers.get(0).getName() + " how many eggs would you want to buy for today?");
        FarmUtils.eggsSail(farm.getEggs(), sc, farm);
        LOGGER.info("eggs count  left: " + eggs.size());

        FarmUtils.milkSail(farm,sc);
        FarmUtils.woolSail(farm,sc);

        LOGGER.info(countPriceDayChickenCorn(farm.getChickens()));
        LOGGER.info(countPriceDayCowHay(farm.getCows()));
        LOGGER.info(countPriceKombikormForDay(farm.getSheeps()));

        LOGGER.info(FarmUtils.countBudget(farm));

        sc.close();
    }
}
