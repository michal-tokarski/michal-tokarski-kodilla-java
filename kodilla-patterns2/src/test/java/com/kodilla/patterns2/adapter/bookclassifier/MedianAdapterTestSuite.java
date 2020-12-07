/*
-------------------------------------------------------------------------------------------
Task 24.5
a) Dwa współpracujące ze sobą systemy biblioteczne (library_A oraz library_B) posiadają zbiór książek
   oraz własne klasy pozwalające na obliczenie mediany roku wydania w ramach księgozbioru
   (mediana to wartość, od której większa jest połowa elementów zbioru oraz mniejsza jest druga połowa elementów zbioru).
b) Pracownicy biblioteki library_A chcą skorzystać z klas obliczających medianę, z których korzysta biblioteka library_B,
   ponieważ nie mają zaufania do swojego algorytmu :)
c) Niestety - typy reprezentujące książki w bibliotekach nieco się różnią, jak również interfejsy klas obliczających medianę.
   Zostałeś zatrudniony jako inżynier oprogramowania, którego zadaniem jest napisanie odpowiedniego adaptera.
(...)
1. W katalogu src/main/java w pakiecie com.kodilla.patterns2.adapter.bookclassifier utwórz klasę MedianAdaptee_B,
   która implementuje interfejs BookStatistics_B oraz używa obiektu klasy Statistics_B do wykonania obliczeń
2. W tym samym pakiecie utwórz klasę MedianAdapter_A,
   która rozszerza klasę MedianAdaptee_B oraz implementuje interfejs Classifier_A,
   a w swoim wnętrzu dokonuje niezbędnych transformacji danych i wywołań
3. W katalogu src/test/java utwórz pakiet com.kodilla.patterns2.adapter.bookclassifier
4. W pakiecie z pkt 3 powyżej utwórz zestaw testów MedianAdapterTestSuite,
   a w nim przypadek testowy publicationYearMedianTest,
   w którym stwórz przykładowy zbiór Set<Book_A> i wywołaj metodę publicationYearMedian() klasy MedianAdapter_A.
   Napisz asercję sprawdzającą czy wynik testu jest zgodny z oczekiwaniami.
   -------------------------------------------------------------------------------------------
 */

package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.library_A.Book_A;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void test_publicationYearMedian_A() {

        //Given
        MedianAdapter_A medianAdapter_A = new MedianAdapter_A();
        Set<Book_A> bookSet_A = new HashSet<>();

        Book_A book1 = new Book_A("William Shakespeare", "Krol Lear", 2015, "1000");
        Book_A book2 = new Book_A("John Steinbeck", "Myszy i Ludzie", 2002, "9678");
        Book_A book3 = new Book_A("Kurt Vonnegut", "Rzeznia nr 5", 2007, "2359");
        Book_A book4 = new Book_A("Jack London", "Na Wschod od Edenu", 2019, "4387");
        Book_A book5 = new Book_A("George Orwell", "Folwark Zwierzecy", 1955, "7712");

        bookSet_A.add(book1);
        bookSet_A.add(book2);
        bookSet_A.add(book3);
        bookSet_A.add(book4);
        bookSet_A.add(book5);

        //When
        int median_A = medianAdapter_A.publicationYearMedian_A(bookSet_A);

        //Then
        System.out.print("Given bookset has following publication years : ");
        for (Book_A book_A : bookSet_A) {
            System.out.print(book_A.getPublicationYear() + " ; ");
        }
        System.out.println("\nMedian publication year is : " + median_A);
        assertEquals(2007, median_A);

    }

}
