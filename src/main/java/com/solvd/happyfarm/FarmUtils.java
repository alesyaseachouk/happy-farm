package com.solvd.happyfarm;

import com.solvd.happyfarm.animal.Chicken;
import com.solvd.happyfarm.animal.Cow;
import com.solvd.happyfarm.animal.Sheep;
import com.solvd.happyfarm.food.Corn;
import com.solvd.happyfarm.food.Food;
import com.solvd.happyfarm.food.Hay;
import com.solvd.happyfarm.food.Kombikorm;
import com.solvd.happyfarm.product.Egg;
import com.solvd.happyfarm.product.Milk;
import com.solvd.happyfarm.product.Wool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FarmUtils {

    private static final Logger LOGGER = LogManager.getLogger(FarmUtils.class.getName());

    public static BigDecimal annualCostEggs(List<Chicken> chickens){
        List<Egg> allEggs = chickens.stream()
                .map(Chicken::getEgg)
                .collect(Collectors.toList());
        BigDecimal annualCostEggs = BigDecimal.valueOf(365L * allEggs.size()).multiply(allEggs.get(0).getPrice().getValue());
        return annualCostEggs;
    }

    public static BigDecimal annualCostMilk(List<Cow> cows){
        List<Milk> allMilk = cows.stream()
                .map(Cow::getMilk)
                .collect(Collectors.toList());
        BigDecimal annualCostMilk = BigDecimal.valueOf(365L * allMilk.size()).multiply(allMilk.get(0).getPrice().getValue());
        LOGGER.info(annualCostMilk);
        LOGGER.info(allMilk);
        return annualCostMilk;
    }

    public static BigDecimal annualCostWool(List<Sheep> sheeps){
        List<Wool> allWool = sheeps.stream()
                .map(Sheep::getWool)
                .collect(Collectors.toList());
        BigDecimal annualCostWool = BigDecimal.valueOf(365L * allWool.size()).multiply(allWool.get(0).getPrice().getValue());
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


//    ранее возвращали List<Egg>

    public static void eggsSail (List<Egg>eggs, Scanner sc ){

        LOGGER.info("Enter Eggs Count: " + eggs.size());
        int eggCount = sc.nextInt();
//        List<Egg> availableEggs = chickens.stream()
//                .filter(chicken -> chicken.getEgg()!=null)
//                .map(chicken -> chicken.getEgg())
//                .collect(Collectors.toList());
        if (eggCount<=eggs.size()){
            LOGGER.info("You can buy these " + eggs.size());
            for (int i=eggs.size()-1; i>eggs.size()-eggCount-1; i--) {
//                chickens.get(i).deleteEgg();
                LOGGER.info("eggs index" + i);
                eggs.remove(i);
            }
        } else {
            LOGGER.info("Sorry, we don't have eggs enough");
        }

//        return availableEggs;

    }

    public static BigDecimal countPriceDayChickenCorn(List<Chicken> chickens){
        List<Food> cornForDay = chickens.stream()
                .map(Chicken::getFood)
                .collect(Collectors.toList());
        BigDecimal cornPriceDay = BigDecimal.valueOf(cornForDay.size()).multiply(cornForDay.get(0).getPrice().getValue());
        return cornPriceDay;
    }
    public static BigDecimal countPriceDayCowHay(List<Cow> cows){
        List<Food> hayForDay= cows.stream()
                .map(Cow::getFood)
                .collect(Collectors.toList());
        BigDecimal hayPriceDay = BigDecimal.valueOf(hayForDay.size()).multiply(hayForDay.get(0).getPrice().getValue());
        return hayPriceDay ;
    }
    public static BigDecimal countPriceKombikormForDay(List<Sheep> sheeps){
        List<Food> kombikormForDay= sheeps.stream()
                .map(Sheep::getFood)
                .collect(Collectors.toList());
        BigDecimal kombikormPriceDay = BigDecimal.valueOf(kombikormForDay.size()).multiply(kombikormForDay.get(0).getPrice().getValue());
        return kombikormPriceDay;
    }

    public static BigDecimal countEggSales(Integer amountEggs, List<Egg> eggs){
        BigDecimal сostEggs = BigDecimal.valueOf(amountEggs).multiply(eggs.get(0).getPrice().getValue());
        return сostEggs;
    }

    public BigDecimal countBudget(Farm farm) {
        BigDecimal countCostEggs;
        BigDecimal countCostMilk;
        BigDecimal countCostWool;
        List<Egg> availableEggs = farm.getChickens().stream()
                .filter(chicken -> chicken.getEgg()!=null)
                .map(chicken -> chicken.getEgg())
                .collect(Collectors.toList());
        if (availableEggs.size() < farm.getEggs().size()) {
            countCostEggs = BigDecimal.valueOf(farm.getEggs().size()-availableEggs.size()).multiply(farm.getEggs().get(0).getPrice().getValue());
        } else {
            countCostEggs = farm.getEggs().get(0).getPrice().getValue().multiply(BigDecimal.valueOf(farm.getEggs().size()));
        }
        double volumeMilkDay = farm.getCows().get(0).getMilk().getVolume()*farm.getCows().size();
        double volumeWoolDay = farm.getSheeps().get(0).getWool().getVolume()*farm.getSheeps().size();
        if (farm.getMilk().getVolume() < volumeMilkDay) {
            countCostMilk =  BigDecimal.valueOf(volumeMilkDay-farm.getMilk().getVolume()).multiply(farm.getMilk().getPrice().getValue());
        } else {
            countCostMilk =  BigDecimal.valueOf(volumeMilkDay).multiply(farm.getMilk().getPrice().getValue());
        }
        if (farm.getWool().getVolume() < volumeWoolDay) {
            countCostWool = BigDecimal.valueOf(volumeWoolDay - farm.getWool().getVolume()).multiply(farm.getWool().getPrice().getValue());
        } else {
            countCostWool = BigDecimal.valueOf(volumeWoolDay).multiply(farm.getWool().getPrice().getValue());
        }
        BigDecimal budget = farm.getBudget().add(countCostEggs).add(countCostMilk).add(countCostWool)
                .subtract(countPriceDayChickenCorn(farm.getChickens())).subtract(countPriceDayCowHay(farm.getCows())).subtract(countPriceKombikormForDay(farm.getSheeps()));
        return budget;
    }
}
