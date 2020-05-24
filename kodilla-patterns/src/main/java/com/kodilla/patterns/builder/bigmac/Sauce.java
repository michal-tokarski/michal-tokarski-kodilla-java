package com.kodilla.patterns.builder.bigmac;

public enum Sauce {

    SAUCE_STANDARD ("Standard"),
    SAUCE_THOUSANDISLANDS ("Thousand Islands"),
    SAUCE_BARBECUE ("Barbecue"),
    ;

    private String name;

    Sauce(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}