package com.kodilla.good.patterns.challenges.Allegro;

public class Customer {

    private String customerID;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String cellphoneNumber;
    private String creditCardNumber;

    public Customer(
            String customerID,
            String firstName,
            String lastName,
            String emailAddress,
            String cellphoneNumber,
            String creditCardNumber)
    {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.cellphoneNumber = cellphoneNumber;
        this.creditCardNumber = creditCardNumber;
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
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getCellphoneNumber() {
        return cellphoneNumber;
    }
    public String getCreditCardNumber() {
        return creditCardNumber;
    }
}
