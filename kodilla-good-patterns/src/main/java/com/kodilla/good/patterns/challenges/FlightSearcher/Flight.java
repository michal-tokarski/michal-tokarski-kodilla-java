package com.kodilla.good.patterns.challenges.FlightSearcher;

import java.time.LocalTime;

public class Flight {
    private String flightID;
    private Airport departureAirport;
    private LocalTime departureTime;
    private Airport arrivalAirport;
    private LocalTime arrivalTime;
    private String connectionType;

    public Flight(
            String flightID,
            Airport departureAirport,
            LocalTime departureTime,
            Airport arrivalAirport,
            LocalTime arrivalTime,
            String connectionType)
    {
        this.flightID = flightID;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.arrivalAirport = arrivalAirport;
        this.arrivalTime = arrivalTime;
        this.connectionType = connectionType;

    }

    public String getFlightID() {
        return flightID;
    }
    public Airport getDepartureAirport() {
        return departureAirport;
    }
    public LocalTime getDepartureTime() {
        return departureTime;
    }
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }
    public LocalTime getArrivalTime() {
        return arrivalTime;
    }
    public String getConnectionType() {return connectionType; }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }
}
