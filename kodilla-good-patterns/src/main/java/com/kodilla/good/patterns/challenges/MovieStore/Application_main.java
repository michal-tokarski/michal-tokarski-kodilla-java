package com.kodilla.good.patterns.challenges.MovieStore;

import java.util.stream.Collectors;

public class Application_main {

    public static void main(String[]args) {

        MovieStore myMovieStore = new MovieStore();

        System.out.println("\nOriginal List :");
        System.out.println("-----------------");
        myMovieStore.getMovies().entrySet().stream()
                .forEach(System.out::println);

        System.out.println("\nRequested List (all titles in one row, separated by exclamation mark) :");
        System.out.println("-------------------------------------------------------------------------");

        System.out.print("Way 1 : ");
        myMovieStore.getMovies().entrySet().stream()
                .map(entry -> entry.getValue() + " ! ")
                .forEach(System.out::print);

        System.out.print("\nWay 2 : ");
        String myList = myMovieStore.getMovies().entrySet().stream()
                .flatMap(title -> title.getValue().stream())
                .collect(Collectors.joining(" ! "));
        System.out.println(myList);

    }

}
