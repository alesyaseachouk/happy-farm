package com.solvd.happyfarm;

import com.solvd.happyfarm.animal.Chicken;
import com.solvd.happyfarm.animal.Cow;
import com.solvd.happyfarm.product.Egg;
import com.solvd.happyfarm.product.Milk;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FarmUtils {

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
        System.out.println(annualCostMilk);
        System.out.println(allMilk);
        return annualCostMilk;


    }
}
