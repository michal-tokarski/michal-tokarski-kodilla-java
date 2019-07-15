
/*
Zadanie:
Test klasy wybierającej parzyste liczby z kolekcji
Celem zadania jest przetestowanie klasy,
która udostępnia metodę przyjmującą jako argument listę ArrayList obiektów typu Integer,
która również zwraca listę (nową) ArrayList obiektów typu Integer,
stanowiących podzbiór danych wejściowych z pominięciem liczb nieparzystych.

Aby przygotować rozwiązanie zadania:
1.	W katalogu src/main/java utwórz pakiet com.kodilla.testing.collection
2.	W utworzonym pakiecie stwórz klasę OddNumbersExterminator, posiadającą metodę exterminate(ArrayList<Integer> numbers)
    o przyjmującą jako argument kolekcję ArrayList liczb typu Integer,
    o która zwraca również kolekcję ArrayList liczb typu Integer,
      stanowiącą podzbiór kolekcji wejściowej z pominięciem liczb nieparzystych.
3.	W katalogu src/test/java utwórz pakiet com.kodilla.testing.collection.
4.	W utworzonym pakiecie stwórz klasę testową (zbiór testów) CollectionTestSuite,
    a w niej napisz testy sprawdzające, czy metoda filtrująca liczby nieparzyste działa poprawnie:
    o testOddNumbersExterminatorEmptyList (sprawdzi, czy klasa zachowuje się poprawnie, gdy lista jest pusta)
    o testOddNumbersExterminatorNormalList (sprawdzi, czy klasa zachowuje się poprawnie, gdy lista zawiera liczby parzyste i nieparzyste)
5.	Użyj również adnotacji @Before oraz @After, aby wyświetlić informację o tym,
    jakie operacje (testy) są aktualnie wykonywane.
Rozwiązanie zadania prześlij do repozytorium GitHub.
Link do repozytorium wklej poniżej i wyślij do mentora.
 */

package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionTestSuite {

    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        OddNumbersExterminator obj = new OddNumbersExterminator();

        //When
        ArrayList<Integer> result = obj.exterminate(numbers);
        System.out.println("Testing emtpy list :" + result);

        //Then
        Assert.assertEquals(0,result.size());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        ArrayList<Integer> numbers = new ArrayList<Integer>
                (Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
        OddNumbersExterminator obj = new OddNumbersExterminator();

        //When
        ArrayList<Integer> result = obj.exterminate(numbers);
        System.out.println("Testing normal list :" + result);

        //Then
        Assert.assertEquals(Arrays.asList(2,4,6,8,10,12,14), result);
    }

}
