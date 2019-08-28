package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain_73_examples2 {

    public static void main(String[] args) {

        System.out.println("Example 1 - filter() :");
        System.out.println("--------------------");
        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);

        System.out.println("\nExample 2 - filter() + toList() :");
        System.out.println("-------------------------------");
        BookDirectory theBookDirectory2 = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory2.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());
        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);

        System.out.println("\nExample 3 - filter() + toMap() :");
        System.out.println("------------------------------");
        BookDirectory theBookDirectory3 = new BookDirectory();
        Map<String, Book> theResultMapOfBooks = theBookDirectory3.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));
        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        System.out.println("\nExample 4 - filter() + joining() :");
        System.out.println("--------------------------------");
        BookDirectory theBookDirectory4 = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory4.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));
        System.out.println(theResultStringOfBooks);

    }

}
