package com.kodilla.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {

    @Test
    public void test_BasicPizzaOrder_GetCost() {
        //Given
        PizzaOrder pizza = new BasicPizzaOrder();
        //When
        BigDecimal theCost = pizza.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(333), theCost);
    }

    @Test
    public void test_BasicPizzaOrder_GetDescription() {
        //Given
        PizzaOrder pizza = new BasicPizzaOrder();
        //When
        String description = pizza.getDescription();
        //Then
        Assert.assertEquals("Basic pizza (standard cheese and tomato sauce)", description);
    }

    @Test
    public void test_BasicPizzaOrder_PlusAllExtrasIncluded_GetCost() {
        //Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new ExtrasExtraCheeseDecorator(pizza);
        pizza = new ExtrasOlivesDecorator(pizza);
        //When
        BigDecimal theCost = pizza.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(666.00), theCost);
    }

    @Test
    public void test_BasicPizzaOrder_PlusAllExtrasIncluded_GetDescription() {
        //Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new ExtrasExtraCheeseDecorator(pizza);
        pizza = new ExtrasOlivesDecorator(pizza);
        //When
        String description = pizza.getDescription();
        //Then
        Assert.assertEquals(
                "Basic pizza (standard cheese and tomato sauce) + extras (extra cheese) + extras (olives)",
                description);
    }

}
