package com.kodilla.stream;

import com.kodilla.stream.person.People;

public class StreamMain_73_examples {

    public static void main(String[] args) {

        System.out.println("Example 1 - stream (list 1) :");
        System.out.println("-----------------------------");
        People.getList().stream()
                .forEach(System.out::println);

        System.out.println("\nExample 2 - stream (transform 1) :");
        System.out.println("------------------------------------");
        People.getList().stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        System.out.println("\nExample 3 - stream (transform 2) :");
        System.out.println("------------------------------------");
        People.getList().stream()
                .map(String::toUpperCase)
                .forEach(s -> System.out.println(s));

        System.out.println("\nExample 4 - stream (filter 1) :");
        System.out.println("--------------------------------");
        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);

        System.out.println("\nExample 5 - stream (transform + filter 1) :");
        System.out.println("---------------------------------------------");
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);

    }

}
