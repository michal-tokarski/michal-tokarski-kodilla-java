package com.kodilla.good.patterns.challenges.Food2Door;

public class Vendor {

    private String vendorID;
    private String vendorName;
    private String email;
    private String cellphone;
    private String address;
    private int defaultDeliveryDays;


    public Vendor(String vendorID, String vendorName, String email, String cellphone, String address, int defaultDeliveryDays) {
        this.vendorID = vendorID;
        this.vendorName = vendorName;
        this.email = email;
        this.cellphone = cellphone;
        this.address = address;
        this.defaultDeliveryDays = defaultDeliveryDays;
    }

    public Vendor() {
    }

    public String getVendorID() {
        return vendorID;
    }
    public String getVendorName() {
        return vendorName;
    }
    public String getEmail() {
        return email;
    }
    public String getCellphone() {
        return cellphone;
    }
    public String getAddress() {
        return address;
    }
    public int getDefaultDeliveryDays() {
        return defaultDeliveryDays;
    }

}
