package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite implements ArrayOperations {

    @Test
    public void testGetAverage() {

        //Given
        int numbers [] = {11,22,33,44,55,66,77,88,99,100,111,222,333,444,555,666,777,888,999,2000};

        //When
        int sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        double expectedAverage = (double) sum / numbers.length;

        //Then
        Assert.assertEquals(expectedAverage, ArrayOperations.getAverage(numbers), 0.000001);
    }
}
