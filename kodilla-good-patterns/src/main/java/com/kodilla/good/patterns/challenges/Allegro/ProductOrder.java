package com.kodilla.good.patterns.challenges.Allegro;

import java.time.LocalDate;

public class ProductOrder {

    private String productOrderID;
    private LocalDate orderDate;
    private Customer customer;
    private Product product;
    private int productQuantity;
    private LocalDate deliveryDate;
    private String paymentMethod;
    private String deliveryAddress;
    private boolean isReceived;
    private boolean isPaid;
    private boolean isAuthorized;
    private boolean isShipped;
    private boolean isDelivered;

    public ProductOrder(
            String productOrderID,
            LocalDate orderDate,
            Customer customer,
            Product product,
            int productQuantity,
            LocalDate deliveryDate,
            String paymentMethod,
            String deliveryAddress,
            boolean isReceived,
            boolean isPaid,
            boolean isAuthorized,
            boolean isShipped,
            boolean isDelivered)
    {
        this.productOrderID = productOrderID;
        this.orderDate = orderDate;
        this.customer = customer;
        this.product = product;
        this.productQuantity = productQuantity;
        this.deliveryDate = deliveryDate;
        this.paymentMethod = paymentMethod;
        this.deliveryAddress = deliveryAddress;
        this.isReceived = isReceived;
        this.isPaid = isPaid;
        this.isAuthorized = isAuthorized;
        this.isShipped = isShipped;
        this.isDelivered = isDelivered;
    }

    public String getProductOrderID() {
        return productOrderID;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Product getProduct() {
        return product;
    }
    public int getProductQuantity() {
        return productQuantity;
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
    public boolean getIsReceived() { return isReceived; }
    public boolean getIsPaid() { return isPaid; }
    public boolean getIsAuthorized() { return isAuthorized; }
    public boolean getIsShipped() { return isShipped; }
    public boolean getIsDelivered() { return isDelivered; }

    public void receive() {
        isReceived = true;
    }
    public void pay() {
        isPaid = true;
    }
    public void authorize() {
        isAuthorized = isPaid;
    }
    public void ship() {
        isShipped = true;
    }
    public void deliver() {
        isDelivered = true;
    }

}
