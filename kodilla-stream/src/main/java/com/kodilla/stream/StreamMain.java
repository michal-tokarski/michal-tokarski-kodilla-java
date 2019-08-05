package com.kodilla.stream;

import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;


public class StreamMain {

    public static void main(String[] args) {

        // Textbook examples

        System.out.println("\nIntroduction :");
        System.out.println("Welcome to module 7 - Stream");

        System.out.println("\nExample 1 :");
        System.out.println("Printing text the orient objected way 1 :");
        SaySomething saySomething = new SaySomething();
        saySomething.say();

        System.out.println("\nExample 2 :");
        System.out.println("Printing text the orient objected way 2 :");
        Processor processor1 = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor1.execute(executeSaySomething);

        System.out.println("\nExample 3 :");
        System.out.println("Printing text the lambda way :");
        Processor processor2 = new Processor();
        Executor codeToExecute = () -> System.out.println("This is an example text - lambda way");
        processor2.execute(codeToExecute);

        System.out.println("\nExample 4 :");
        System.out.println("Calculating expressions with lambda expressions :");
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("\nExample 5 :");
        System.out.println("Calculating expressions with method references :");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);


    }
}

