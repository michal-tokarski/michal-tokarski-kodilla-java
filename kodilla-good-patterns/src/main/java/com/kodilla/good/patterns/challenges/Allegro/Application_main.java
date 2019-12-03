package com.kodilla.good.patterns.challenges.Allegro;

/*
Module 13.2 - SOLID + DRY
Task :
Wewnątrz pakietu com.kodilla.good.patterns.challenges stwórz klasę ProductOrderService.
Serwis powinien zajmować się wykonywaniem zamówień różnego rodzaju produktów
- gier, kapcie, szczoteczek do zębów… innymi słowy, Allegro :)
Pamiętaj o stworzeniu niezbędnych interfejsów i klas które będą implementować stworzone interfejsy.
Program należy uruchomić za pomocą metody main().
 */

public class Application_main {

    public static void main(String[]args) {

        // Create dummy product order
        ProductOrderRetriever myProductOrderRetriever = new ProductOrderRetriever();
        ProductOrder myProductOrder = myProductOrderRetriever.createDummyOrder();

        // Simulate as if order received, paid, authorized
        myProductOrder.receive();
        myProductOrder.pay();
        myProductOrder.authorize();

        // Create an object for servicing the product order
        ProductOrderService myProductOrderService = new ProductOrderService(
                myProductOrder,
                new InfoService_email(),
                new ProductOrderRepository()
                );

        // Process the product order
        myProductOrderService.process(myProductOrder);

    }
}
