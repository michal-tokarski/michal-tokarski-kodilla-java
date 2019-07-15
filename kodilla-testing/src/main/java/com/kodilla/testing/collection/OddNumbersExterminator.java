package com.kodilla.testing.collection;
import java.util.ArrayList;

public class OddNumbersExterminator {

    public ArrayList<Integer> exterminate (ArrayList<Integer> numbers) {

        int temporaryValue = 0;
        ArrayList<Integer> evenNumbers = new ArrayList<Integer>();

        for (int n=0; n < numbers.size(); n++){
            temporaryValue = numbers.get(n);
            //checking if an element is even or odd
            if (temporaryValue % 2 == 0){
                evenNumbers.add(temporaryValue);
            }
        }

        return evenNumbers;

    }

}
