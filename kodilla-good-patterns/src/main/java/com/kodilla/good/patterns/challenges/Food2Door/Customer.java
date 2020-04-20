package com.kodilla.good.patterns.challenges.Food2Door;

public class Customer {
    private String customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String cellphone;
    private String creditCardNumber;
    private String address;
    private boolean isCustomerBlacklisted;

    public Customer(
            String customerID,
            String firstName,
            String lastName,
            String email,
            String cellphone,
            String creditCardNumber,
            String address,
            boolean isCustomerBlacklisted)
    {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.creditCardNumber = creditCardNumber;
        this.address = address;
        this.isCustomerBlacklisted = isCustomerBlacklisted;
    }

    public Customer() {
    }

    public String getCustomerID() {
        return customerID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getCellphone() {
        return cellphone;
    }
    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    public String getAddress() {
        return address;
    }
    public boolean getIsCustomerBlacklisted() {
        return isCustomerBlacklisted;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

