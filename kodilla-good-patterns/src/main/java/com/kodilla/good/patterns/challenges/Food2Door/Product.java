package com.kodilla.good.patterns.challenges.Food2Door;

public class Product {
    private String productID;
    private String productName;
    private String vendorID;
    private double price;
    private int stockQuantity;
    private int minimumOrderQuantity;

    public Product(String productID, String productName, String vendorID, double price, int stockQuantity, int minimumOrderQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.vendorID = vendorID;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.minimumOrderQuantity = minimumOrderQuantity;
    }

    public Product() {
    }

    public String getProductID() {
        return productID;
    }
    public String getProductName() {
        return productName;
    }
    public String getVendorID() {
        return vendorID;
    }
    public double getPrice() {
        return price;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }
    public int getMinimumOrderQuantity() {
        return minimumOrderQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", name='" + productName + '\'' +
                ", vendorID='" + vendorID + '\'' +
                ", price=" + price +
                ", inStockQuantity=" + stockQuantity +
                ", minimumOrderQuantity=" + minimumOrderQuantity +
                '}';
    }
}
