package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.ArrayList;
import java.util.Random;

public class Customer_Retriever {

    public ArrayList<Customer> customerList = new ArrayList<>();

    public ArrayList<Customer> initializeCustomerList() {

        Customer customer1 = new Customer(
                "C_0001",
                "Zdzislaw",
                "Maklakiewicz",
                "zdzislaw.maklakiewicz@wp.pl",
                "780-111-444",
                "7777-2222-8888-3333",
                "Warszawa PL, ul. Marszalkowska 105 m. 37",
                true);

        Customer customer2 = new Customer(
                "C_0002",
                "Marilyn",
                "Monroe",
                "marilyn.monroe@interial.pl",
                "345-333-491",
                "1234-3582-2222-8399",
                "Beverly Hills CA USA, 1645 Mulholland Drive",
                false);

        Customer customer3 = new Customer(
                "C_0003",
                "Franz",
                "Beckenbauer",
                "franz.beckenbauer@gmail.com",
                "987-390-455",
                "4321-4926-7777-4811",
                "Monachium DE, Sabinerstrasse 15",
                false);

        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);

        return customerList;

    }

    public Customer getRandomCustomer(){

        initializeCustomerList();

        Random random = new Random();
        int randomIndex = random.nextInt(customerList.size());
        return customerList.get(randomIndex);

    }

    public Customer retrieveCustomerByID (String searchID) {

        Customer foundCustomer = new Customer();
        initializeCustomerList();

        for (Customer customer : customerList) {
            if (customer.getCustomerID() == searchID) {
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }
}
