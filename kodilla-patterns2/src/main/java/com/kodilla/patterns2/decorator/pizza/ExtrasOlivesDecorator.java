package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtrasOlivesDecorator extends AbstractPizzaOrderDecorator {

    public ExtrasOlivesDecorator (PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(111.00));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + extras (olives)";
    }

}
