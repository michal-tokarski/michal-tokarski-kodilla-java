package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {

        // Given
        // Creating sample 'Library' object
        Library baseLibrary = new Library("Base Library");

        // Creating sample 'Book' objects
        Book book1 = new Book("Pan Cogito", "Zbigniew Herbert", LocalDate.of(2017, 1, 13));
        Book book2 = new Book("Les Miserables", "Victor Hugo", LocalDate.of(1981, 10, 25));
        Book book3 = new Book("Slaughterhouse 5", "Kurt Vonnegut", LocalDate.of(2005, 4, 8));

        // Adding the books to the set 'books'
        baseLibrary.getBooks().add(book1);
        baseLibrary.getBooks().add(book2);
        baseLibrary.getBooks().add(book3);

        // Making a shallow copy of the object 'baseLibrary'
        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = baseLibrary.shallowCopy();
            shallowClonedLibrary.setName("Shallow-Clone Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        // Making a deep copy of the object 'baseLibrary'
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = baseLibrary.deepCopy();
            deepClonedLibrary.setName("Deep-Clone Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        // When
        // Remove books from the Base Library
        baseLibrary.getBooks().remove(book2);
        baseLibrary.getBooks().remove(book3);

        // Then
        // Print library name with their books
        System.out.println(baseLibrary);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);

        // Check
        Assert.assertEquals(1, baseLibrary.getBooks().size());
        Assert.assertEquals(1, shallowClonedLibrary.getBooks().size());
        Assert.assertEquals(3, deepClonedLibrary.getBooks().size());

        Assert.assertEquals(baseLibrary.getBooks(), shallowClonedLibrary.getBooks());
        Assert.assertNotEquals(baseLibrary.getBooks(), deepClonedLibrary.getBooks());

    }
}
