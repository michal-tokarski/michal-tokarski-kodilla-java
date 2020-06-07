package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "PRODUCTS")
public class Product {
    private int productID;
    private String productName;

    public Product() {
    }

    public Product(String productName) {
        this.productName = productName;
    }

    // Getters :
    // -------------------------------

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID", unique = true)
    public int getProductID() {
        return productID;
    }

    @NotNull
    @Column(name = "PRODUCTNAME")
    public String getProductName() {
        return productName;
    }

    // Setters :
    // -------------------------------

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
