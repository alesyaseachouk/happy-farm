package com.solvd.happyfarm;

import com.solvd.happyfarm.animal.Chicken;
import com.solvd.happyfarm.animal.Cow;
import com.solvd.happyfarm.animal.Sheep;
import com.solvd.happyfarm.product.Egg;
import com.solvd.happyfarm.product.Milk;
import com.solvd.happyfarm.product.Wool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
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

    public static BigDecimal annualCostMilk(Set<Cow> cows){
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

}
