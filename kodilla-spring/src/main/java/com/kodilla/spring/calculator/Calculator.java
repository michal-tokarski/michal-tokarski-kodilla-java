package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {

    @Autowired
    // Display display = new Display(); // @Autowired makes the object creation unnecessary
    Display display;

    Double add(double a, double b){
        Double result = 0.0;
        result = a + b;
        System.out.print("Addition : " + a + " + " + b + " = ");
        display.displayValue(result);
        return result;
    }

    Double subtract(double a, double b){
        Double result = 0.0;
        result = a - b;
        System.out.print("Subtraction : " + a + " - " + b + " = ");
        display.displayValue(result);
        return result;
    }

    Double multiply(double a, double b){
        Double result = 0.0;
        result = a * b;
        System.out.print("Multiplication : " + a + " * " + b + " = ");
        display.displayValue(result);
        return result;
    }

    Double divide(double a, double b) {
        Double result = 0.0;
        result = a / b;
        System.out.print("Division : " + a + " ÷ " + b + " = ");
        display.displayValue(result);
        return result;
    }

}
