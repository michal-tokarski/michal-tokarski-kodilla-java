package com.kodilla.exception.test;

public class Flight {
    private String departureAirport;
    private String arrivalAirport;

    public Flight(String departureAirport, String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (getDepartureAirport() != null ? !getDepartureAirport().equals(flight.getDepartureAirport()) : flight.getDepartureAirport() != null)
            return false;
        return getArrivalAirport() != null ? getArrivalAirport().equals(flight.getArrivalAirport()) : flight.getArrivalAirport() == null;
    }

    @Override
    public int hashCode() {
        int result = getDepartureAirport() != null ? getDepartureAirport().hashCode() : 0;
        result = 31 * result + (getArrivalAirport() != null ? getArrivalAirport().hashCode() : 0);
        return result;
    }
}

