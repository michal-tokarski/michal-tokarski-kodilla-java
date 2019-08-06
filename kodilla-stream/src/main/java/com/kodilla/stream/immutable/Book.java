package com.kodilla.stream.immutable;

public final class Book {
    private final String title;
    private final String author;
    private final int yearOfPublication;

    public Book(final String title, final String author,
                final int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
    /*
    Gdy spróbujesz w IntelliJ wpisać powyższy kod, otrzymasz błąd w metodzie modifyYearOfPublication(int year) mówiący o tym,
    że nie można modyfikować pól klasy oznaczonych jako final.
    Jedyne dozwolone miejsce, w którym możemy ustawić wartość takiego pola to konstruktor (usuń tę metodę po sprawdzeniu błędu):

    public void modifyYearOfPublication(int year) {
        yearOfPublication = year;
    }
     */

}
