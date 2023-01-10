package com.solvd.happyfarm;

import com.solvd.happyfarm.animal.Chicken;
import com.solvd.happyfarm.animal.Cow;
import com.solvd.happyfarm.animal.Sheep;
import com.solvd.happyfarm.exception.InvalidVaccinationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import static com.solvd.happyfarm.FarmBuilder.*;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    static void printMenu() {
        LOGGER.info("\n1 - Eggs \n2 - Milk \n3 - Wool ");
    }

    public static void main(String[] args) throws InvalidVaccinationException {

        Farm farm = new Farm();

        Scanner sc = new Scanner(System.in);

        LOGGER.info("Enter Chickens Count: ");
        int chickenCount = sc.nextInt();
        LOGGER.info("Here are all farm chickens: " + chickenCount);

        List<Chicken> chickens = chickenBuilder(chickenCount);
        chickens.forEach(chicken -> LOGGER.info(chicken));

        LOGGER.info("Enter Cows Count: ");
        int cowCount = sc.nextInt();
        LOGGER.info("Here are all farm cows: " + cowCount);

        Set<Cow> cows = cowBuilder(cowCount);
        cows.forEach(cow -> LOGGER.info(cow));

        LOGGER.info("Enter Sheep Count: ");
        int sheepCount = sc.nextInt();
        LOGGER.info("Here are all farm cows: " + sheepCount);

        List<Sheep> sheeps = sheepBuilder(sheepCount);
        sheeps.forEach(sheep -> LOGGER.info(sheep));

//        LOGGER.info("Enter Farm Budget: ");

//        int budget = sc.nextInt();
//        farm.setChickens(farm.getChickens());

//        farm.setBudget(budget);

//        LOGGER.info("Farm Budget = " + budget + " BYN");

//        LOGGER.info("______________Products you can buy______________ ");
//        printMenu();
//
//        LOGGER.info("Enter eggs count: ");
//        int number1 = sc.nextInt();
//        LOGGER.info("Eggs count: " + number1 );
//
//        LOGGER.info("Enter milk volume: ");
//        int number2 = sc.nextInt();
//        LOGGER.info("Milk volume: " + number2 );
//
//        LOGGER.info("Enter wool volume: ");
//        int number3 = sc.nextInt();
//        LOGGER.info("Wool volume: " + number3 );

        sc.close();
    }

}
