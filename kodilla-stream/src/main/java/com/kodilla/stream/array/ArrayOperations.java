package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {

        double numbersAverage = 0;

        System.out.println("Array elements :");
        IntStream.range(0,numbers.length)
                .map(s -> numbers[s])
                .forEach(s -> System.out.println(s));

        numbersAverage = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average()
                .getAsDouble();

        System.out.println("--------------------------");
        System.out.println("Sum of elements..........." + IntStream.of(numbers).sum());
        System.out.println("No. of elements..........." + numbers.length);
        System.out.println("Arithmetic average........" + numbersAverage);

        return numbersAverage;

    }
}
