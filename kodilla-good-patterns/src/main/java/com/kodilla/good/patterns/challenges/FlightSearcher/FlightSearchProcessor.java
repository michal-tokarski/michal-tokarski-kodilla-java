package com.kodilla.good.patterns.challenges.FlightSearcher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchProcessor {

    public List<Flight> searchByDepartureAirport
            (List<Flight> flightList, Airport selectedAirport) {

            return flightList.stream()
                    .filter(n -> n.getDepartureAirport().equals(selectedAirport))
                    .collect(Collectors.toList());
        }

    public List<Flight> searchByArrivalAirport
            (List<Flight> flightList, Airport selectedAirport) {

            return flightList.stream()
                    .filter(n -> n.getArrivalAirport().equals(selectedAirport))
                    .collect(Collectors.toList());
    }

    public List<Flight> seachDirectFlights
            (List<Flight> flightList, Airport departureAirport, Airport arrivalAirport) {

        return flightList.stream()
                .filter(n -> n.getDepartureAirport().equals(departureAirport)&& n.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toList());
    }

    public List<Flight> seachIndirectFlights
            (List<Flight> flightList, Airport departureAirport, Airport arrivalAirport) {

        List<Flight> flightsFromDepartureAirport = searchByDepartureAirport(flightList, departureAirport);
        List<Flight> flightsToArrivalAirport = searchByArrivalAirport(flightList, arrivalAirport);

        List<Flight> resultList = new ArrayList<>();

        for (Flight flightDeparture : flightsFromDepartureAirport){

            for (Flight flightArrival : flightsToArrivalAirport){

                if (flightDeparture.getArrivalAirport().equals(flightArrival.getDepartureAirport())){
                    flightDeparture.setConnectionType("stopover 1/2");
                    resultList.add(flightDeparture);
                    flightArrival.setConnectionType("stopover 2/2");
                    resultList.add(flightArrival);
                }
            }
        }
        return resultList;
    }

    public List<Flight> seachDirectAndIndirectFlights
            (List<Flight> flightList, Airport departureAirport, Airport arrivalAirport) {

        List<Flight> resultListDirect;
        List<Flight> resultListIndirect;
        List<Flight> resultListCombined = new ArrayList<>();

        resultListDirect = seachDirectFlights(flightList, departureAirport, arrivalAirport);
        resultListIndirect = seachIndirectFlights(flightList, departureAirport, arrivalAirport);

        resultListCombined.addAll(resultListDirect);
        resultListCombined.addAll(resultListIndirect);

        return resultListCombined;
    }

}
