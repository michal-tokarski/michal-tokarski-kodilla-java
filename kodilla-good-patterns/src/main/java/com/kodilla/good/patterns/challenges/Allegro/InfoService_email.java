package com.kodilla.good.patterns.challenges.Allegro;

public class InfoService_email implements InfoService {

    @Override

    public void notifyCustomer (ProductOrder productOrder, String message) {
        System.out.println("To : " + productOrder.getCustomer().getEmailAddress());
        System.out.println(message);
    }

}
