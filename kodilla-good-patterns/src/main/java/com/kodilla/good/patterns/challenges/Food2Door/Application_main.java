package com.kodilla.good.patterns.challenges.Food2Door;

/*
Module 13.4
Task - Food2Door :
-------------------------------
Firma “Food2Door” zajmuje się dystrybucją lokalnych i świeżych produktów z okolicznych wiosek.
Produkty można zamawiać przez internet, a następnie kurier dostarcza je do naszego domu.
(...) system musi zostać rozszerzony o podsystem podłączenia producentów.
Proces zamawiania produktów od różnych producentów zawsze jest taki sam (...)

Wszyscy z tych producentów różnią się nieco implementacją, jednakże schemat zamawiania przebiega następująco :
1. Pobieramy informacje o dostawcy, oraz ilości i rodzaju produktu,
2. Następnie każdy z producentów posiada metodę process(), która pozwala na zrealizowanie tego zamówienia w danym sklepie
3. Dalsza część również wygląda wszędzie tak samo, zwracane są informacje czy udało się zrealizować zamówienie

To zadanie jest naprawdę 'otwarte' na Twoją inwencję twórczą
- spróbuj napisać rozwiązanie, które pozwoli na sprawne 'dołączanie' do istniejącego systemu wielu nowych producentów.
Załóż, że całość systemu poza tym, co zostało zawarte w powyższych punktach jest nieistotna
- napisz kod odzwierciedlający tylko te wytyczne, ...
 wymyślając jednocześnie drobne różnice w implementacji metody process() dla każdego producenta :)
-------------------------------
 */

public class Application_main {

    public CustomerOrder randomCustomerOrder;

    public static void main(String[]args) {

        // Application header :
        System.out.println("Food2Door Application");
        System.out.println("=====================" + "\n");

        // Default product list :
        Product_Retriever objProduct_Retriever = new Product_Retriever();
        objProduct_Retriever.printProductList(objProduct_Retriever.initializeProductList());

        // Random customer order :
        CustomerOrder_Retriever objCustomerOrder_Retriever = new CustomerOrder_Retriever();
        CustomerOrder randomCustomerOrder = objCustomerOrder_Retriever.createRandomCustomerOrder();
        objCustomerOrder_Retriever.printCustomerOrder(randomCustomerOrder);

        // Process the order with vendors :
        OrderRunner objOrderRunner = new OrderRunner();
        objOrderRunner.run(randomCustomerOrder);

    }
}
