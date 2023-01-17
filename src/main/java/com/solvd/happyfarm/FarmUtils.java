package com.solvd.happyfarm;

import com.solvd.happyfarm.animal.Chicken;
import com.solvd.happyfarm.animal.Cow;
import com.solvd.happyfarm.animal.Sheep;
import com.solvd.happyfarm.food.Food;
import com.solvd.happyfarm.product.Egg;
import com.solvd.happyfarm.product.Milk;
import com.solvd.happyfarm.product.Wool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FarmUtils {

    private static final Logger LOGGER = LogManager.getLogger(FarmUtils.class.getName());

    public static double annualCostEggs(List<Chicken> chickens){
        List<Egg> allEggs = chickens.stream()
                .map(Chicken::getEgg)
                .collect(Collectors.toList());
        double annualCostEggs = 365L * allEggs.size()*allEggs.get(0).getPrice().getValue();
        return annualCostEggs;
    }

    public static double annualCostMilk(List<Cow> cows){
        List<Milk> allMilk = cows.stream()
                .map(Cow::getMilk)
                .collect(Collectors.toList());
        double annualCostMilk = 365L * allMilk.size()*(allMilk.get(0).getPrice().getValue());
        LOGGER.info(annualCostMilk);
        LOGGER.info(allMilk);
        return annualCostMilk;
    }

    public static double annualCostWool(List<Sheep> sheeps){
        List<Wool> allWool = sheeps.stream()
                .map(Sheep::getWool)
                .collect(Collectors.toList());
        double annualCostWool = 365L * allWool.size()*allWool.get(0).getPrice().getValue();
        return annualCostWool;
    }

//    public static BigDecimal countPriceDayChickenCorn(List<Chicken> chickens){
//        List<Food> cornForDay = chickens.stream()
//                .map(Chicken::getFood)
//                .collect(Collectors.toList());
//        BigDecimal cornPriceDay = BigDecimal.valueOf(cornForDay.size()).multiply(cornForDay.get(0).getPrice().getValue());
//        return cornPriceDay;
//    }
//    public static BigDecimal countPriceDayCowHay(List<Cow> cows){
//        List<Food> hayForDay= cows.stream()
//                .map(Cow::getFood)
//                .collect(Collectors.toList());
//        BigDecimal hayPriceDay = BigDecimal.valueOf(hayForDay.size()).multiply(hayForDay.get(0).getPrice().getValue());
//        return hayPriceDay ;
//    }
//    public static BigDecimal countPriceKombikormForDay(List<Sheep> sheeps){
//        List<Food> kombikormForDay= sheeps.stream()
//                .map(Sheep::getFood)
//                .collect(Collectors.toList());
//        BigDecimal kombikormPriceDay = BigDecimal.valueOf(kombikormForDay.size()).multiply(kombikormForDay.get(0).getPrice().getValue());
//        return kombikormPriceDay;
//    }

//    ранее возвращался List<Egg>

    public static Farm eggsSail (List<Egg>eggs, Scanner sc, Farm farm ){
        LOGGER.info("Enter Eggs Count: " + "available " + eggs.size());
        int eggCount = sc.nextInt();
        List<Egg> availableEggs = farm.getChickens().stream()
                .filter(chicken -> chicken.getEgg()!=null)
                .map(chicken -> chicken.getEgg())
                .collect(Collectors.toList());
        if (eggCount<=eggs.size()){
            LOGGER.info("You can buy these " + eggs.size());
            Iterator<Egg> iterator = eggs.iterator();
            int count = 0;
            while (iterator.hasNext()){ // пока в коллекции есть след яйцо цикл работает
                Egg egg = iterator.next();
                if (count < eggCount){
                    System.out.println("we are selling: "  + egg);
                    count++;
                    iterator.remove(); // удаляем из коллекции яйцо
                }
                // если не попали в if , значит продали нужное кол-во яиц
                else {
                    break;
                }
            }
        } else {
            LOGGER.info("Sorry, we don't have enough eggs ");
        }
        farm.setEggs(availableEggs);

        double count1 = 0;
        for (int i = 0; i< availableEggs.size() ; i++) {
            count1 = count1+availableEggs.get(i).getPrice().getValue();
        }
        farm.setBudget(count1);
        return farm;
    }
    public static void milkSail (Farm farm, Scanner sc ) {
        LOGGER.info("Enter Milk volume: ");
        Double milkVolume = sc.nextDouble();
        Double farmMilkVolume = farm.getMilk().getVolume();
        if (milkVolume <= farmMilkVolume) {
            LOGGER.info("You can buy these");
            farm.getMilk().setVolume(farmMilkVolume - milkVolume);
        } else {
            LOGGER.info("Sorry, we don't have milk enough");
        }
    }

    public static void woolSail (Farm farm, Scanner sc) {
        LOGGER.info("Enter Wool Volume: ");
        int countWoolDay = sc.nextInt();
        Wool newWool = farm.getWool();
        if (countWoolDay <= newWool.getVolume()) {
            LOGGER.info("You can buy wool ");
            newWool = farm.getWool();
        } else {
            LOGGER.info("Sorry, we don't have enough wool ");
        }
    }
    public static double countPriceDayChickenCorn(List<Chicken> chickens){
        List<Food> cornForDay = chickens.stream()
                .map(Chicken::getFood)
                .collect(Collectors.toList());
        double cornPriceDay = cornForDay.size()*(cornForDay.get(0).getPrice().getValue());
        return cornPriceDay;
    }
    public static double countPriceDayCowHay(List<Cow> cows){
        List<Food> hayForDay= cows.stream()
                .map(Cow::getFood)
                .collect(Collectors.toList());
        double hayPriceDay = hayForDay.size()* hayForDay.get(0).getPrice().getValue();
        return hayPriceDay ;
    }
    public static double countPriceKombikormForDay(List<Sheep> sheeps){
        List<Food> kombikormForDay= sheeps.stream()
                .map(Sheep::getFood)
                .collect(Collectors.toList());
        double kombikormPriceDay = kombikormForDay.size()*kombikormForDay.get(0).getPrice().getValue();
        return kombikormPriceDay;
    }

    public static double countEggSales(Integer amountEggs, List<Egg> eggs){
        double сostEggs = amountEggs*eggs.get(0).getPrice().getValue();
        return сostEggs;
    }

    public static double countBudget(Farm farm) {
        double countCostEggs;
        double countCostMilk;
        double countCostWool;
        List<Egg> availableEggs = farm.getChickens().stream()
                .filter(chicken -> chicken.getEgg()!=null)
                .map(chicken -> chicken.getEgg())
                .collect(Collectors.toList());
        if (availableEggs.size() < farm.getEggs().size()) {
            countCostEggs = (farm.getEggs().size()-availableEggs.size())*farm.getEggs().get(0).getPrice().getValue();
        } else {
            countCostEggs = farm.getEggs().get(0).getPrice().getValue()*farm.getEggs().size();
        }
        double volumeMilkDay = farm.getCows().get(0).getMilk().getVolume()*farm.getCows().size();
        double volumeWoolDay = farm.getSheeps().get(0).getWool().getVolume()*farm.getSheeps().size();
        if (farm.getMilk().getVolume() < volumeMilkDay) {
            countCostMilk =  (volumeMilkDay-farm.getMilk().getVolume())*farm.getMilk().getPrice().getValue();
        } else {
            countCostMilk =  volumeMilkDay*farm.getMilk().getPrice().getValue();
        }
        if (farm.getWool().getVolume() < volumeWoolDay) {
            countCostWool = (volumeWoolDay - farm.getWool().getVolume())*(farm.getWool().getPrice().getValue());
        } else {
            countCostWool = volumeWoolDay*(farm.getWool().getPrice().getValue());
        }
        double budget = farm.getBudget()+countCostEggs+countCostMilk+countCostWool-countPriceDayChickenCorn(farm.getChickens())
                -countPriceDayCowHay(farm.getCows())- countPriceKombikormForDay(farm.getSheeps());
        return budget;
    }
}
