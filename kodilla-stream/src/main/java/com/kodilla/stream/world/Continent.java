package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {

    private String continentName ;
    private List<Country> countries = new ArrayList <>() ;

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public String getContinentName() {
        return continentName;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public List<Country> getCountries() {
        return countries;
    }
}
