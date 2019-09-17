package com.kodilla.exception.test;

import java.util.HashMap;

public class FlightSearchEngine {

    // Create database of airports
    private HashMap <String, Boolean> AirportMap() {

        HashMap <String, Boolean> airportMap = new HashMap<>();
        airportMap.put("WAW", true);
        airportMap.put("NYC", false);
        airportMap.put("CHI", true);
        airportMap.put("LAX", true);
        airportMap.put("MOS", false);

        return airportMap;
    }

    public boolean findFilght(Flight flight) throws RouteNotFoundException {

        if (AirportMap().containsKey(flight.getArrivalAirport()) && AirportMap().get(flight.getArrivalAirport())) {
            return true;
        }
            throw new RouteNotFoundException("N/A");
        }

}
