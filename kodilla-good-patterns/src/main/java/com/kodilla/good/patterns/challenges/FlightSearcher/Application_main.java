package com.kodilla.good.patterns.challenges.FlightSearcher;

/*
Module 13.5
Task - Flight Searcher :
-------------------------------
Zadanie: Wyzwanie - loty
Mamy do czynienia z bardzo małą firmą lotniczą, która oferuje prywatne loty.
Do tej pory, wszystko było uzgadniane przez telefon bezpośrednio z klientem,
 jednak zarząd firmy stwierdził, że jest to bardzo niewydajne rozwiązanie,
  ponieważ wiele razy muszą powtarzać to samo,
   a klienci mają problemy z dodzwonieniem się do firmy ze względu na ograniczoną ilość konsultantów.
Uznano, że dobrze byłoby stworzyć system, który posiadałby zapisaną listę wszystkich lotów, np. GDAŃSK -> WROCŁAW.
System mimo samego przetrzymywania lotów powinien zawierać serwis, który pozwoliłby nam operację związane z wyszukiwaniem lotów jak:
1.	Znalezienie wszystkich lotów z podanego miasta
2.	Znalezienie wszystkich lotów do danego miasta
3.	Znalezienie lotów poprzez inne miasto np. lot z Gdańska przez Kraków do Wrocławia
Firma zna się na technologiach i wymaga użycia iteracji za pomocą Stream oraz spodziewa się wykorzystania kontraktu Equals i Hashcode.
Czy dasz radę rozwiązać problem tej firmy lotniczej?
 */

import java.util.List;

public class Application_main {

    public static void main(String[] args) {

        // --------------------
        // Application header :
        System.out.println("Flight Searcher Application");
        System.out.println("===========================" + "\n");

        // ------------------
        // Full flight list :
        System.out.println("Full flight list :");
        Flight_Retriever objFlight_Retriever = new Flight_Retriever();
        List<Flight> fullFlightList = objFlight_Retriever.initializeFlightList();
        objFlight_Retriever.printFlightList(fullFlightList);

        // ------------------------------------------------
        // Direct flights from searched departure airport :

        Airport searchedDepatureAirport = Airport.WAW;

        System.out.println("Direct flights from " + "<<" + searchedDepatureAirport.getName() + ">>" + " :");

        FlightSearchProcessor objFlightSearchProcessor1 = new FlightSearchProcessor();

        List<Flight> resultFlightList1 = objFlightSearchProcessor1.searchByDepartureAirport(fullFlightList, searchedDepatureAirport);
        objFlight_Retriever.printFlightList(resultFlightList1);

        // --------------------------------------------
        // Direct flights to searched arrival airport :
        Airport searchedArrivalAirport = Airport.LON;

        System.out.println("Direct flights to " + "<<" + searchedArrivalAirport.getName() + ">>" + " :");

        FlightSearchProcessor objFlightSearchProcessor2 = new FlightSearchProcessor();

        List<Flight> resultFlightList2 = objFlightSearchProcessor2.searchByArrivalAirport(fullFlightList, searchedArrivalAirport);
        objFlight_Retriever.printFlightList(resultFlightList2);

        // -------------------------------------------------------------------------------------
        // Direct and indirect flights from searched departure and to searched arrival airport :
        searchedDepatureAirport = Airport.PAR;
        searchedArrivalAirport = Airport.WAW;

        System.out.println("Direct and indirect flights from " + "<<" + searchedDepatureAirport.getName() + ">>"
                + " to " + "<<" + searchedArrivalAirport.getName() + ">>" + " :");

        FlightSearchProcessor objFlightSearchProcessor3 = new FlightSearchProcessor();

        List<Flight> resultFlightList3
            = objFlightSearchProcessor3.seachDirectAndIndirectFlights(fullFlightList, searchedDepatureAirport, searchedArrivalAirport);
        objFlight_Retriever.printFlightList(resultFlightList3);

    }
}
