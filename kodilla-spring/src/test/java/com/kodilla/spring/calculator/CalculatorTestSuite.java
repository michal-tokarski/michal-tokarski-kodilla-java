package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTestSuite {

    @Test
    public void testCalculations_Addition() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator objCalculator = context.getBean(Calculator.class);
        Double a = 3.5; Double b = 20.0;
        //When
        Double result = objCalculator.add(a, b);
        //Then
        Assert.assertEquals(23.5, result, 0.01);
    }

    @Test
    public void testCalculations_Subtraction() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator objCalculator = context.getBean(Calculator.class);
        Double a = 493.0; Double b = 589.0;
        //When
        Double result = objCalculator.subtract(a, b);
        //Then
        Assert.assertEquals(-96.0, result, 0.01);
    }

    @Test
    public void testCalculations_Multiplication() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator objCalculator = context.getBean(Calculator.class);
        Double a = 12.0; Double b = 12.0;
        //When
        Double result = objCalculator.multiply(a, b);
        //Then
        Assert.assertEquals(144.0, result, 0.01);
    }

    @Test
    public void testCalculations_Division() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator objCalculator = context.getBean(Calculator.class);
        Double a = 200.0; Double b = 5.0;
        //When
        Double result = objCalculator.divide(a, b);
        //Then
        Assert.assertEquals(40.0, result, 0.01);
    }

}
