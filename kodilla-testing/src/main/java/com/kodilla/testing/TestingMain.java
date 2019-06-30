package com.kodilla.testing;

/*
 Previous version
public class TestingMain {
    public static void main(String[] args){
        System.out.println("Moduł 6. Wprowadzenie do testowania oprogramowania");
    }
}
*/

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {

    public static void main(String[] args){

        System.out.println ("--------------------");
        System.out.println ("1. Unit test");
        System.out.println ("Class Simple user");

        SimpleUser simpleUser = new SimpleUser ("theForumUser");
        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println ("--------------------");
        System.out.println ("2. Unit test");
        System.out.println ("Class Calculator");

        Calculator calculator = new Calculator();

        int A = 20;
        int B = 33;

        System.out.println("Addition: " + A + " + " + B);
        int result1 = calculator.add(A, B);
        if (result1 == (A+B)){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Subtraction: " + A + " - " + B);
        int result2 = calculator.subtract(A, B);
        if (result2 == (A-B)){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

    }
}


