package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.ArrayList;
import java.util.Random;

public class Product_Retriever  {

    public ArrayList<Product> productList = new ArrayList<>();

    public ArrayList<Product> initializeProductList() {

        Product product1 = new Product(
                "P_0001",
                "Regular Milk",
                "V_0001",
                20.50,
                100,
                10);

        Product product2 = new Product(
                "P_0002",
                "Sweet Potatoes",
                "V_0001",
                10.25,
                400,
                50);

        Product product3 = new Product(
                "P_0003",
                "Special Bread",
                "V_0002",
                67.00,
                5000,
                20);

        Product product4 = new Product(
                "P_0004",
                "Special Beef",
                "V_0002",
                39.00,
                300,
                20);

        Product product5 = new Product(
                "P_0005",
                "Wholesome Milk",
                "V_0003",
                15.00,
                40,
                30);

        Product product6 = new Product(
                "P_0006",
                "Smoked Salmon",
                "V_0003",
                123.00,
                800,
                30);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);

        return productList;

    }

    public void printProductList(ArrayList<Product> productList){
        System.out.println("Default product list :");
        System.out.println("----------------------");
        System.out.printf("%-15s %-20s %-15s %-20s %15s %15s %15s",
                "[Product ID]", "[Product name]", "[Vendor ID]", "[Vendor name]", "[Price]", "[In Stock]", "[Min Order]");
        System.out.println();

        for(Product product: productList){
            System.out.format("%-15s %-20s %-15s %-20s %15s %15s %15s",
                    product.getProductID(),
                    product.getProductName(),
                    product.getVendorID(),
                    (new Vendor_Retriever().retrieveVendorByID(product.getVendorID())).getVendorName(),
                    product.getPrice(),
                    product.getStockQuantity(),
                    product.getMinimumOrderQuantity());
            System.out.println();
        }
        System.out.println();
    }

    public Product getRandomProduct(){

        int randomIndex = 1;
        initializeProductList();

        Random random = new Random();
        randomIndex = random.nextInt(productList.size());
        return productList.get(randomIndex);
    }

    public Product retrieveProductByID (String searchID) {

        Product foundProduct = new Product();
        initializeProductList();

        for (Product product : productList) {
            if (product.getProductID() == searchID) {
                foundProduct = product;
                break;
            }
        }
        return foundProduct;
    }

}