package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtrasExtraCheeseDecorator extends AbstractPizzaOrderDecorator {

    public ExtrasExtraCheeseDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(222.00));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + extras (extra cheese)";
    }

}
