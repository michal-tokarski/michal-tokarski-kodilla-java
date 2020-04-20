package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.HashMap;
import java.util.Map;

public class OrderRunner {

    Map<String, OrderProcessor> orderRunner = new HashMap<>();
    {
        orderRunner.put("V_0001", new OrderProcessor_ExtraFoodShop());
        orderRunner.put("V_0002", new OrderProcessor_GlutenFreeShop());
        orderRunner.put("V_0003", new OrderProcessor_HealthyShop());
    }

    //@Override
    public void run (CustomerOrder customerOrder)
    {
        System.out.println("Vendors feedback :");
        System.out.println("------------------");

        for(ShoppingItem shoppingItem : customerOrder.getShoppingCart2()) {
            OrderProcessor orderProcessor = orderRunner.get(shoppingItem.getProduct().getVendorID());
            orderProcessor.process(shoppingItem);
        }
    }

}

