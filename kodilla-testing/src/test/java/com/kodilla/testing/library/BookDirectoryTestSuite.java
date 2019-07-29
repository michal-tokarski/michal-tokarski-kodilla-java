package com.kodilla.testing.library;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class BookDirectoryTestSuite {

    private static int testCounter = 0;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Test suite has begun ...\n");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("\nTest suite completed.");
    }

    @Before
    public void beforeEveryTest(){

        testCounter++;
        System.out.println("Executing test no. " + testCounter + " " + "...");

    }

    @After
    public void afterEveryTest(){
        System.out.println("Test completed.");
    }


    @Test
        public void testListBooksWithConditionsReturnList() {

            System.out.println("testListBooksWithConditionsReturnList");

            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            List<Book> resultListOfBooks = new ArrayList<Book>();

            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);

            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);

            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

            // When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

            // Then
            assertEquals(4, theListOfBooks.size());

        }

        @Test
        public void testListBooksWithConditionMoreThan20() {

            System.out.println("testListBooksWithConditionMoreThan20");

            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            List<Book> resultListOf0Books = new ArrayList<Book>();
            List<Book> resultListOf15Books = generateListOfNBooks(15);
            List<Book> resultListOf40Books = generateListOfNBooks(40);

            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

            // When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

            // Then
            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theListOfBooks15.size());
            assertEquals(0, theListOfBooks40.size());

        }

        @Test
        public void testListBooksWithConditionFragmentShorterThan3() {

            System.out.println("testListBooksWithConditionFragmentShorterThan3");

            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf10Books = generateListOfNBooks(10);
            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);

            // When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

            // Then
            assertEquals(0, theListOfBooks10.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());

        }

        @Test
        public void testlistBooksInHandsOf() {

            System.out.println("testlistBooksInHandsOf");

            //Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            List<Book> resultListOf0Books = generateListOfNBooks(0);
            List<Book> resultListOf1Books = generateListOfNBooks(1);
            List<Book> resultListOf5Books = generateListOfNBooks(5);

            LibraryUser myLibraryUser0 = new LibraryUser("James", "Bond", "undisclosed");
            LibraryUser myLibraryUser1 = new LibraryUser("Freddie", "Mercury", "undisclosed");
            LibraryUser myLibraryUser5 = new LibraryUser("Janis", "Joplin", "undisclosed");

            when(libraryDatabaseMock.listBooksInHandsOf(myLibraryUser0)).thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksInHandsOf(myLibraryUser1)).thenReturn(resultListOf1Books);
            when(libraryDatabaseMock.listBooksInHandsOf(myLibraryUser5)).thenReturn(resultListOf5Books);

            //When
            List<Book> theListOf0Books = bookLibrary.listBooksInHandsOf(myLibraryUser0);
            List<Book> theListOf1Books = bookLibrary.listBooksInHandsOf(myLibraryUser1);
            List<Book> theListOf5Books = bookLibrary.listBooksInHandsOf(myLibraryUser5);

            //Then
            assertEquals(0, theListOf0Books.size());
            assertEquals(1, theListOf1Books.size());
            assertEquals(5, theListOf5Books.size());

        }

    }
