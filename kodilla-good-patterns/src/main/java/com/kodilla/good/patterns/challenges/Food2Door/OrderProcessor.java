package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Map;

public interface OrderProcessor {

    Map<String, Integer> getStockQuantity();
    Map<String, Integer> getMinimumOrderQuantity();

    void process (ShoppingItem shoppingItem);

    default boolean checkIfInStock (String productID, int orderQuantity, int stockQuantity) {
        boolean exists = getStockQuantity().containsKey(productID);
        if (exists){
            return orderQuantity <= stockQuantity;
        }
        return false;
    }

    default boolean checkIfMinimumOrderQuantity (String productID, int orderQuantity, int minimumOrderQuantity) {
        boolean exists = getMinimumOrderQuantity().containsKey(productID);
        if (exists){
            return orderQuantity >= minimumOrderQuantity;
        }
        return false;
    }

}
