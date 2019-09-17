package com.kodilla.exception;

import com.kodilla.exception.test.Flight;
import com.kodilla.exception.test.FlightSearchEngine;
import com.kodilla.exception.test.RouteNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class ExceptionMain_Task84 {

    public static void main (String args []) {

        // Case 1 : Destination is not available
        Flight flight1  = new Flight("WAW" , "NYC");
        // Case 2 : Destination is available
        Flight flight2  = new Flight("WAW" , "CHI");

        Set<Flight> flights = new HashSet<>();
        flights.add(flight1);
        flights.add(flight2);

        String message1 = "Requested destination is available";
        String message2 = "Requested destination is currently not available";

        for (Flight flight : flights) {

            try {
                System.out.println("Searched flight : " + flight.getDepartureAirport() + " -> " + flight.getArrivalAirport());
                FlightSearchEngine search = new FlightSearchEngine();
                search.findFilght(flight);
                System.out.println(message1);
            } catch (RouteNotFoundException e) {
                System.out.println(message2);
            } finally {
                System.out.println("End of search");
            }

        }

    }
}
