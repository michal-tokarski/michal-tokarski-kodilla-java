package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderProcessor_ExtraFoodShop implements OrderProcessor {

    final String constantVendorID = "V_0001";

    @Override
    public Map<String, Integer> getStockQuantity() {

        ArrayList<Product> productList = new Product_Retriever().initializeProductList();
        Map<String, Integer> map = new HashMap<>();

        for(Product product: productList){
            if (product.getVendorID() == constantVendorID) {
                map.put (product.getProductID(), product.getStockQuantity());
            }
        }
        return map;
    }

    @Override
    public Map<String, Integer> getMinimumOrderQuantity() {

        ArrayList<Product> productList = new Product_Retriever().initializeProductList();
        Map<String, Integer> map = new HashMap<>();

        for(Product product: productList){
            if (product.getVendorID() == constantVendorID) {
                map.put (product.getProductID(), product.getMinimumOrderQuantity());
            }
        }
        return map;
    }



    @Override
    public void process(ShoppingItem shoppingItem) {

        String productID = shoppingItem.getProduct().getProductID();
        String productName = shoppingItem.getProduct().getProductName();
        String vendorName = new Vendor_Retriever().retrieveVendorByID(shoppingItem.getProduct().getVendorID()).getVendorName();
        int orderedQuantity = shoppingItem.getQuantity();
        int stockQuantity = getStockQuantity().get(productID);
        int minimumOrderQuantity = getMinimumOrderQuantity().get(productID);

        if (checkIfInStock (productID, orderedQuantity, stockQuantity)) {

            if (checkIfMinimumOrderQuantity (productID, orderedQuantity, minimumOrderQuantity)) {
                System.out.println(
                        vendorName + " - " +"Ordered product " + "'" + productName + "'" + " is processed successfully");

            } else {
                System.out.println(
                        vendorName + " - " + "Minimum ordered quantity not met for the product " + "'" + productName + "'"
                        + " - " + orderedQuantity + " < " + minimumOrderQuantity);
            }

        } else {
            System.out.println(
                    vendorName + " - " + "Not sufficient stock of the product " + "'" + productName + "'"
                    + " - " + orderedQuantity + " > " + stockQuantity);
        }

    }
}
