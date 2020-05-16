package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void logTest() {

        //Given
        Logger.getInstance().log("User 123");
        Logger.getInstance().log("User 456");

        //When
        String lastLog = Logger.getInstance().getLastLog();

        //Then
        Assert.assertEquals("User 456", lastLog);

    }
}
