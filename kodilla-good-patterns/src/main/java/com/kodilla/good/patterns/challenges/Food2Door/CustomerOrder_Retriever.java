package com.kodilla.good.patterns.challenges.Food2Door;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class CustomerOrder_Retriever  {

    public Customer randomCustomer;
    public CustomerOrder randomCustomerOrder;
    public ArrayList<ShoppingItem> shoppingCart2;

    public CustomerOrder createRandomCustomerOrder() {

        Customer randomCustomer = new Customer_Retriever().getRandomCustomer();

        CustomerOrder randomCustomerOrder = new CustomerOrder(
                "O_" + (new Random().nextInt(999999)+1),
                randomCustomer.getCustomerID(), // customerID
                LocalDate.now(), // orderDate
                LocalDate.now().plusDays(2), // by default, deliveryDate = orderDate + 2 days
                "credit card",
                randomCustomer.getAddress(), // by default, deliveryAddress = customers address
                shoppingCart2 = new ArrayList<>()
                );


        // by default, 3 random products are added to shoppingCart
        randomCustomerOrder.addItemToShoppingCart2 (new ShoppingItem(
                new Product_Retriever().getRandomProduct(),
                new Random().nextInt(100) + 1,
                randomCustomerOrder.getDeliveryDate(),
                new Customer_Retriever().retrieveCustomerByID(randomCustomerOrder.getCustomerID()).getIsCustomerBlacklisted()
        ));
        randomCustomerOrder.addItemToShoppingCart2 (new ShoppingItem(
                new Product_Retriever().getRandomProduct(),
                new Random().nextInt(200) + 1,
                randomCustomerOrder.getDeliveryDate(),
                new Customer_Retriever().retrieveCustomerByID(randomCustomerOrder.getCustomerID()).getIsCustomerBlacklisted()
        ));
        randomCustomerOrder.addItemToShoppingCart2 (new ShoppingItem(
                new Product_Retriever().getRandomProduct(),
                new Random().nextInt(300) + 1,
                randomCustomerOrder.getDeliveryDate(),
                new Customer_Retriever().retrieveCustomerByID(randomCustomerOrder.getCustomerID()).getIsCustomerBlacklisted()
        ));

        randomCustomerOrder.calculateTotalAmount();

        return randomCustomerOrder;
    }

    public void printCustomerOrder(CustomerOrder customerOrder){

        System.out.println("Random customer order :");
        System.out.println("-----------------------");
        System.out.println("Order ID .......................: " + customerOrder.getCustomerOrderID());
        System.out.println("Order Date .....................: " + customerOrder.getOrderDate());
        System.out.println("Customer ID ....................: " + customerOrder.getCustomerID());
        System.out.println("Customer Name ..................: " +
                (new Customer_Retriever().retrieveCustomerByID(customerOrder.getCustomerID())).getFirstName() + " " +
                (new Customer_Retriever().retrieveCustomerByID(customerOrder.getCustomerID())).getLastName() );
        System.out.println("Delivery Date ..................: " + customerOrder.getDeliveryDate());
        System.out.println("Delivery Address ...............: " + customerOrder.getDeliveryAddress());
        System.out.println("Blacklisted customer ...........: " +
                (new Customer_Retriever().retrieveCustomerByID(customerOrder.getCustomerID())).getIsCustomerBlacklisted() );
        System.out.println("Shopping cart ..................: ");
        System.out.printf("%-15s %-20s %-15s %-20s %15s %15s %15s",
                "[Product ID]", "[Product name]", "[Vendor ID]", "[Vendor name]", "[Price]", "[Quantity]", "[Amount]");
        System.out.println();

        for(ShoppingItem shoppingItem : customerOrder.getShoppingCart2()){
            System.out.format("%-15s %-20s %-15s %-20s %15s %15s %15s",
                    shoppingItem.getProduct().getProductID(),
                    shoppingItem.getProduct().getProductName(),
                    shoppingItem.getProduct().getVendorID(),
                    (new Vendor_Retriever().retrieveVendorByID(shoppingItem.getProduct().getVendorID()).getVendorName()),
                    shoppingItem.getPrice(),
                    shoppingItem.getQuantity(),
                    shoppingItem.getAmount()
            );
            System.out.println();
        }

        System.out.format("%-15s %-20s %-15s %-20s %15s %15s %15s",
                "","","","","","Total =", customerOrder.calculateTotalAmount());
        System.out.println();
    }


}
