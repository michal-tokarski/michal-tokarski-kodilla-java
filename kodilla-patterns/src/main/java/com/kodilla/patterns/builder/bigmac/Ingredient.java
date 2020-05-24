package com.kodilla.patterns.builder.bigmac;

public enum Ingredient {

    INGR_LETTUCE ("Lettuce"),
    INGR_ONION ("Onion"),
    INGR_BACON ("Bacon"),
    INGR_CUCUMBER ("Cucumber"),
    INGR_CHILLI ("Chilli"),
    INGR_CHAMPIGNONS ("Champignons"),
    INGR_SHRIMPS ("Shrimps"),
    INGR_CHEESE ("Cheese"),
    ;

    private String name;

    Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}