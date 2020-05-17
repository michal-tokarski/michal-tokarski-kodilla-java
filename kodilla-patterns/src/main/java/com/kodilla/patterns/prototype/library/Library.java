package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library)super.clone();
        clonedLibrary.books = new HashSet<>();
        for(Book theBook : books) {
            Book clonedBook = new Book(theBook.getTitle(), theBook.getAuthor(), theBook.getPublicationDate());
            clonedLibrary.books.add(clonedBook);
        }
        return clonedLibrary;
    }

    public String printBooks() {
        int i = 1;
        String booksString = "";
        for (Book theBook : books) {
            booksString = booksString + ("\n" + i + ". " + "'" + theBook.getTitle() + "'"
                    + " by " + theBook.getAuthor()
                    + " (" + "published : " + theBook.getPublicationDate() +")");
            i++;
        }
        return booksString;
    }

    @Override
    public String toString() {
        return name + " : " + printBooks();
    }
}
