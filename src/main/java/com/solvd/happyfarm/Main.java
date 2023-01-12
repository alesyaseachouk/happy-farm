package com.solvd.happyfarm;

import com.solvd.happyfarm.customer.Customer;
import com.solvd.happyfarm.exception.InvalidVaccinationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import static com.solvd.happyfarm.FarmBuilder.*;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws InvalidVaccinationException {

        Farm farm = new Farm();
        Scanner sc = new Scanner(System.in);

        farm.setBudget(FarmBuilder.budgetBuilder(sc));
        farm.setChickens(chickenBuilder(sc));
        farm.setCows(cowBuilder(sc));
        farm.setSheeps(sheepBuilder(sc));

//        Milk milk = countMilkDay(cowBuilder(sc));

        LOGGER.info("All farm animals: \n " + farm);

        List<Customer> customers = FarmBuilder.customerBuilder(sc);
        farm.setCustomers(customers);

        LOGGER.info(farm);


//        List<Customer> regularlyCustomers = customers.stream()
//                .filter(customer -> customer.getRegularly()==true)
//                .collect(Collectors.toList());

//        double volumeMilkDay = cows.get(0).getMilk().getVolume()*cows.size();
//        farm.setMilk(volumeMilkDay);
//
//        Wool wool = countWoolDay(sheeps);
//        farm.setWools(wool);

//        LOGGER.info("Hello, "+ regularlyCustomers.get(0).getName() + " how many products would you want to buy for today?");

//        LOGGER.info("Enter Eggs Count: ");
//        int eggCount = sc.nextInt();
//        if (eggCount<=eggs.size()){
//            LOGGER.info("You can buy these ");
//            for (int i=0; i<eggCount; i++) {
//                eggs.get(i)=null;
//            }
//            eggs = eggs.stream()
//                    .filter(egg -> egg!=null)
//                    .collect(Collectors.toList());
//        } else {
//            LOGGER.info("Sorry, we don't have enough eggs ");
//        }
//
        sc.close();
    }

}
