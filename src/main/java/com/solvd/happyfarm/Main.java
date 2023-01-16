package com.solvd.happyfarm;

import com.solvd.happyfarm.animal.Chicken;
import com.solvd.happyfarm.customer.Customer;
import com.solvd.happyfarm.exception.InvalidVaccinationException;
import com.solvd.happyfarm.product.Egg;
import com.solvd.happyfarm.product.Milk;
import com.solvd.happyfarm.product.Wool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.stream.Collectors;

import static com.solvd.happyfarm.FarmBuilder.*;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

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

//        LOGGER.info(countPriceDayChickenCorn(farm.getChickens()));
//        LOGGER.info(countPriceDayCowHay(farm.getCows()));
//        LOGGER.info(countPriceKombikormForDay(farm.getSheeps()));

        List<Customer> customers = customerBuilder(sc);
        farm.setCustomers(customers);

        LOGGER.info(farm);

        List<Customer> regularlyCustomers = customers.stream()
                .filter(Customer::getRegularly)
                .collect(Collectors.toList());

        LOGGER.info("Hello, "+ regularlyCustomers.get(0).getName() + " how many eggs would you want to buy for today?");

//        LOGGER.info("Enter Eggs Count: ");

//        int countEggsDay = sc.nextInt();
//        List<Egg> newEggs = farm.getEggs();
//        if (countEggsDay <= newEggs.size()){
//            LOGGER.info("You can buy these ");
//            for (int i=0; i<countEggsDay; i++) {
//                farm.getChickens().get(i).deleteEgg();
//            }
//            newEggs = eggs.stream()
//                    .filter(egg -> egg!=null)
//                    .collect(Collectors.toList());
//        } else {
//            LOGGER.info("Sorry, we don't have enough eggs ");
//        }


        LOGGER.info("Enter Milk volume: ");
        Double milkVolume = sc.nextDouble();
        Double farmMilkVolume = farm.getMilk().getVolume();
        if (milkVolume<=farmMilkVolume ) {
            LOGGER.info("You can buy these");
            farm.getMilk().setVolume(farmMilkVolume - milkVolume);
        } else {
            LOGGER.info("Sorry, we don't have milk enough");
        }

        LOGGER.info("Enter Wool Volume: ");

        int countWoolDay = sc.nextInt();
        Wool newWool = farm.getWool();
        if (countWoolDay <= newWool.getVolume()){
            LOGGER.info("You can buy wool ");
            newWool = farm.getWool();
        } else {
            LOGGER.info("Sorry, we don't have enough wool ");
        }

        System.out.println(" count eggs left:1 " + eggs.size());

        FarmUtils.eggsSail(eggs,sc);
        System.out.println(" count eggs left2: " + eggs.size());

        sc.close();
    }
}
