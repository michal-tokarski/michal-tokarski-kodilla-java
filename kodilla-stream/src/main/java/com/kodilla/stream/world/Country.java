package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {

    private String countryName;
    private BigDecimal peopleQuantity;

    public Country(String countryName, BigDecimal peopleQuantity) {
        this.countryName = countryName;
        this.peopleQuantity = peopleQuantity;
    }

    public String getCountryName() {
        return countryName;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return getCountryName().equals(country.getCountryName());
    }

    @Override
    public int hashCode() {
        return getCountryName().hashCode();
    }
}
