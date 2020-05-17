package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies()  {

        //Given
        User millUser = new Millenials("Funny Millenials Guy");
        User ygenUser = new YGeneration("Weird YGeneration Guy");
        User zgenUser = new ZGeneration("Romantic ZGeneration Guy");

        //When
        String millUserMessage = millUser.sharePost();
        String ygenUserMessage = ygenUser.sharePost();
        String zgenUserMessage = zgenUser.sharePost();

        System.out.println("\ntestDefaultSharingStrategies()" + " : ");
        System.out.println(millUser.getUserName() + " : " + millUserMessage + "(default channel)");
        System.out.println(ygenUser.getUserName() + " : " + ygenUserMessage + "(default channel)");
        System.out.println(zgenUser.getUserName() + " : " + zgenUserMessage + "(default channel)");

        //Then
        Assert.assertEquals("This message has been shared via Snapchat", millUserMessage);
        Assert.assertEquals("This message has been shared via Facebook", ygenUserMessage);
        Assert.assertEquals("This message has been shared via Twitter", zgenUserMessage);
    }

    @Test
    public void testIndividualSharingStrategy()  {

        //Given
        User millUser = new Millenials("Funny Millenials Guy");
        millUser.setCustomPublisher(new TwitterPublisher());

        //When
        System.out.println("\ntestIndividualSharingStrategy()" + " : ");
        String millUserMessage = millUser.sharePost();
        System.out.println(millUser.getUserName() + " : " + millUserMessage + "(customized channel)");

        //Then
        Assert.assertEquals("This message has been shared via Twitter", millUserMessage);
    }

}
