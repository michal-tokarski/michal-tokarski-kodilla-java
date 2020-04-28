package com.kodilla.good.patterns.challenges.FlightSearcher;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Flight_Retriever {

    public List<Flight> initializeFlightList() {

        List<Flight> flightList = new ArrayList<>();

        Flight flight1 = new Flight("LO5678",
                Airport.WAW, LocalTime.of(17,15),
                Airport.KRK, LocalTime.of(18,15),
                "direct flight");

        Flight flight2 = new Flight("LO1234",
                Airport.WAW, LocalTime.of(10,30),
                Airport.MOS, LocalTime.of(13,30),
                "direct flight");

        Flight flight3 = new Flight("LH6612",
                Airport.BER, LocalTime.of(20,40),
                Airport.GDN, LocalTime.of(21,40),
                "direct flight");

        Flight flight4 = new Flight("LH6619",
                Airport.BER, LocalTime.of(8,55),
                Airport.KRK, LocalTime.of(9,55),
                "direct flight");

        Flight flight5 = new Flight("IB6612",
                Airport.KAT, LocalTime.of(13,45),
                Airport.WAW, LocalTime.of(14,20),
                "direct flight");

        Flight flight6 = new Flight("BA1539",
                Airport.LON, LocalTime.of(18,20),
                Airport.WAW, LocalTime.of(20,50),
                "direct flight");

        Flight flight7 = new Flight("AF9547",
                Airport.PAR, LocalTime.of(19,30),
                Airport.WAW, LocalTime.of(21,0),
                "direct flight");

        Flight flight8 = new Flight("AE1111",
                Airport.MOS, LocalTime.of(19,30),
                Airport.GDN, LocalTime.of(21,0),
                "direct flight");

        Flight flight9 = new Flight("LO4822",
                Airport.WRO, LocalTime.of(6,30),
                Airport.WAW, LocalTime.of(7,30),
                "direct flight");

        Flight flight10 = new Flight("LO5559",
                Airport.KRK, LocalTime.of(7,35),
                Airport.LON, LocalTime.of(9,45),
                "direct flight");

        Flight flight11 = new Flight("BA1135",
                Airport.LON, LocalTime.of(20,5),
                Airport.KAT, LocalTime.of(22,30),
                "direct flight");

        Flight flight12 = new Flight("AE8319",
                Airport.MOS, LocalTime.of(17,10),
                Airport.WAW, LocalTime.of(20,30),
                "direct flight");

        Flight flight13 = new Flight("IB2229",
                Airport.MAD, LocalTime.of(7,40),
                Airport.WRO, LocalTime.of(10,20),
                "direct flight");

        Flight flight14 = new Flight("AF9733",
                Airport.PAR, LocalTime.of(8,30),
                Airport.KAT, LocalTime.of(11,10),
                "direct flight");

        Flight flight15 = new Flight("LO8823",
                Airport.WRO, LocalTime.of(7,30),
                Airport.PAR, LocalTime.of(10,55),
                "direct flight");

        Flight flight16 = new Flight("IB8331",
                Airport.MAD, LocalTime.of(9,35),
                Airport.MOS, LocalTime.of(15,45),
                "direct flight");

        Flight flight17 = new Flight("LH9444",
                Airport.BER, LocalTime.of(19,10),
                Airport.LON, LocalTime.of(20,20),
                "direct flight");

        Flight flight18 = new Flight("AF1839",
                Airport.PAR, LocalTime.of(8,40),
                Airport.MOS, LocalTime.of(14,45),
                "direct flight");

        Flight flight19 = new Flight("LO4555",
                Airport.GDN, LocalTime.of(20,30),
                Airport.PAR, LocalTime.of(22,55),
                "direct flight");

        Flight flight20 = new Flight("BA9333",
                Airport.LON, LocalTime.of(19,15),
                Airport.MOS, LocalTime.of(23,50),
                "direct flight");

        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        flightList.add(flight4);
        flightList.add(flight5);
        flightList.add(flight6);
        flightList.add(flight7);
        flightList.add(flight8);
        flightList.add(flight9);
        flightList.add(flight10);
        flightList.add(flight11);
        flightList.add(flight12);
        flightList.add(flight13);
        flightList.add(flight14);
        flightList.add(flight15);
        flightList.add(flight16);
        flightList.add(flight17);
        flightList.add(flight18);
        flightList.add(flight19);
        flightList.add(flight20);

        return flightList;

    }

    public void printFlightList(List<Flight> flightList){

        System.out.printf("%-15s %-20s %-15s %-20s %-15s %-25s",
                "[Flight ID]", "[Dep. Airport]", "[Dep. Time]", "[Arr. Airport]", "[Arr. Time]", "[Connection Type]");
        System.out.println();

        int i=0;
        for(Flight flight: flightList){
            System.out.format("%-15s %-20s %-15s %-20s %-15s %-25s",
                    flight.getFlightID(),
                    flight.getDepartureAirport().getName(),
                    flight.getDepartureTime(),
                    flight.getArrivalAirport().getName(),
                    flight.getArrivalTime(),
                    flight.getConnectionType()
            );
            System.out.println();
        }
        System.out.println();
    }



}
