package com.kodilla.good.patterns.challenges.Allegro;

public class Product {

    private String productID;
    private String name;
    private double price;
    private boolean isAvailable;
    private String warehouseAddress;

    public Product(
            String productID,
            String name,
            double price,
            boolean isAvailable,
            String warehouseAddress)
    {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.warehouseAddress = warehouseAddress;
    }

    public String getProductID() {
        return productID;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public boolean getIsAvailable() {
        return isAvailable;
    }
    public String getWarehouseAddress() {
        return warehouseAddress;
    }
}
