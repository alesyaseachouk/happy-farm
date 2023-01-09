package com.solvd.happyfarm;

import com.solvd.happyfarm.exception.InvalidVaccinationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    static void printMenu() {
        LOGGER.info("\n1 - Eggs \n2 - Milk \n3 - Wool ");
    }

    public static void main(String[] args) throws InvalidVaccinationException {

        Farm farm = new Farm();

        Scanner sc = new Scanner(System.in);

        LOGGER.info("Enter Farm Budget: ");

        int budget = sc.nextInt();

        farm.setBudget(budget);

        LOGGER.info("Farm Budget = " + budget + " BYN");

        LOGGER.info("______________Products you can buy______________ ");
        printMenu();

        LOGGER.info("Enter eggs count: ");
        int number1 = sc.nextInt();
        LOGGER.info("Eggs count: " + number1 );

        LOGGER.info("Enter milk volume: ");
        int number2 = sc.nextInt();
        LOGGER.info("Milk volume: " + number2 );

        LOGGER.info("Enter wool volume: ");
        int number3 = sc.nextInt();
        LOGGER.info("Wool volume: " + number3 );

        sc.close();

    }
}
