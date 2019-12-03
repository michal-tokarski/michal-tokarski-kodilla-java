package com.kodilla.good.patterns.challenges.Allegro;

import java.time.LocalDate;
import java.time.Month;

public class ProductOrderRetriever {

    public ProductOrder createDummyOrder() {

        // Create Customer :
        Customer myCustomer = new Customer(
                "C_001",
                "Robert",
                "DeNiro",
                "robert.deniro@gmail.com",
                "780-111-444",
                "7777-2222-8888-3333");

        // Create Product :
        Product myProduct = new Product(
                "P_001",
                "Whiskey Johnnie Walker - 1l",
                200,
                true,
                "San Bernandino CA, 125 Main Street");

        // Create Product Order:
        ProductOrder myProductOrder = new ProductOrder(
                "PO_000001",
                LocalDate.of(2019, Month.NOVEMBER, 20),
                myCustomer,
                myProduct,
                50,
                LocalDate.of(2019, Month.NOVEMBER, 22),
                "Credit Card",
                "New York NY, 41 Park Avenue",
                false,
                false,
                false,
                false,
                false
                );

        return myProductOrder;

    }

}
