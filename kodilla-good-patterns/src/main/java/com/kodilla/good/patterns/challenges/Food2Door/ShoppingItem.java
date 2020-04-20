package com.kodilla.good.patterns.challenges.Food2Door;

import java.time.LocalDate;

public class ShoppingItem {

    private Product product;
    private int quantity;
    private double price;
    private double amount;
    private LocalDate deliveryDate;
    private boolean isCustomerBlacklisted;

    public ShoppingItem(Product product, int quantity, LocalDate deliveryDate, boolean isCustomerBlacklisted) {
        this.product = product;
        this.quantity = quantity;
        this.price = new Product_Retriever().retrieveProductByID(product.getProductID()).getPrice();
        this.amount = quantity * price;
        this.deliveryDate = deliveryDate;
        this.isCustomerBlacklisted = isCustomerBlacklisted;
    }

    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public double getAmount() {
        return amount;
    }
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
    public boolean getIsCustomerBlacklisted() {
        return isCustomerBlacklisted;
    }
}
