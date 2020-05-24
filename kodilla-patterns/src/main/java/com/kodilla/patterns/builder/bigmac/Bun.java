package com.kodilla.patterns.builder.bigmac;

public enum Bun {

    BUN_PLAIN("Plain bun"),
    BUN_SESAME("Sesame bun"),
    ;

    private String name;

    Bun(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
