package com.kodilla.good.patterns.challenges.Food2Door;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerOrder {
    private String customerOrderID;
    private String customerID;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String paymentMethod;
    private String deliveryAddress;
    private ArrayList<ShoppingItem> shoppingCart2;
    private double totalAmount;

    public CustomerOrder(
            String customerOrderID,
            String customerID,
            LocalDate orderDate,
            LocalDate deliveryDate,
            String paymentMethod,
            String deliveryAddress,
            ArrayList<ShoppingItem> shoppingCart2
            )

    {
        this.customerOrderID = customerOrderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.paymentMethod = paymentMethod;
        this.deliveryAddress = deliveryAddress;
        this.shoppingCart2 = new ArrayList<>();
        this.totalAmount = calculateTotalAmount();
    }


    public String getCustomerOrderID() {
        return customerOrderID;
    }
    public String getCustomerID() {
        return customerID;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public ArrayList<ShoppingItem> getShoppingCart2() {
        return shoppingCart2;
    }

    public void addItemToShoppingCart2(ShoppingItem shoppingItem) {
        shoppingCart2.add(shoppingItem);
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;

        for(ShoppingItem shoppingItem : shoppingCart2) {
            totalAmount = totalAmount + shoppingItem.getAmount();
        }
        return totalAmount;
    }


}
