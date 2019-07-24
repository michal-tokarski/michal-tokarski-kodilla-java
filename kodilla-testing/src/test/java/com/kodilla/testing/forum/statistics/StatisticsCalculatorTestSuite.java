package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsCalculatorTestSuite {

    private static int testCounter = 0;

    private Statistics statisticsMock;
    private StatisticsCalculator statisticsCalculator;

    private List<String> generateUsers (int count) {

        List<String> usersList = new ArrayList<> ();

        for (int i=0 ; i<count ; i++){
                usersList.add("User" + i+1);
            }
            return usersList;
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
        System.out.println("\nExecuting test no. " + testCounter + " " + "...");

        statisticsMock = mock(Statistics.class);
        statisticsCalculator = new StatisticsCalculator(statisticsMock);

    }

    @After
    public void afterEveryTest(){
        System.out.println("Test completed.");
    }

    @Test // unit test 1
    public void testCalculateAdvStatistics_T01_WhenPostsCount0(){

        System.out.println("testCalculateAdvStatistics_T01_WhenPostsCount0");

        //Given
        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(900);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, statisticsCalculator.getPostsCount());
        assertEquals(0, statisticsCalculator.getAvgPostsPerUser(), 0.01);
        assertEquals(0, statisticsCalculator.getAvgCommentsPerPost(), 0.01);

    }

    @Test // unit test 2
    public void testCalculateAdvStatistics_T02_WhenPostsCount1000(){

        System.out.println("testCalculateAdvStatistics_T02_WhenPostsCount1000");

        //Given
        when(statisticsMock.usersNames()).thenReturn(generateUsers(200));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(400);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showAdvStatistics(statisticsMock);
        //Then
        assertEquals(1000, statisticsCalculator.getPostsCount());
        assertEquals(5, statisticsCalculator.getAvgPostsPerUser(), 0.01);
        assertEquals(0.4, statisticsCalculator.getAvgCommentsPerPost(), 0.01);

    }

    @Test // unit test 3
    public void testCalculateAdvStatistics_T03_WhenCommentsCount0(){

        System.out.println("testCalculateAdvStatistics_T03_WhenCommentsCount0");

        //Given
        when(statisticsMock.usersNames()).thenReturn(generateUsers(300));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, statisticsCalculator.getCommentsCount());
        assertEquals(0, statisticsCalculator.getAvgCommentsPerUser(), 0.01);
        assertEquals(0, statisticsCalculator.getAvgCommentsPerPost(), 0.01);

    }

    @Test // unit test 4
    public void testCalculateAdvStatistics_T04_WhenFewerCommentsThanPosts(){

        System.out.println("testCalculateAdvStatistics_T04_WhenFewerCommentsThanPosts");

        //Given
        when(statisticsMock.usersNames()).thenReturn(generateUsers(400));
        when(statisticsMock.postsCount()).thenReturn(700);
        when(statisticsMock.commentsCount()).thenReturn(200);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showAdvStatistics(statisticsMock);
        //Then
        assertEquals(700, statisticsCalculator.getPostsCount());
        assertEquals(200, statisticsCalculator.getCommentsCount());
        assertEquals(1.75, statisticsCalculator.getAvgPostsPerUser(), 0.01);
        assertEquals(0.5, statisticsCalculator.getAvgCommentsPerUser(), 0.01);
        assertEquals(0.29, statisticsCalculator.getAvgCommentsPerPost(), 0.01);

    }

    @Test // unit test 5
    public void testCalculateAdvStatistics_T05_WhenMoreCommentsThanPosts(){

        System.out.println("testCalculateAdvStatistics_T05_WhenMoreCommentsThanPosts");

        //Given
        when(statisticsMock.usersNames()).thenReturn(generateUsers(500));
        when(statisticsMock.postsCount()).thenReturn(200);
        when(statisticsMock.commentsCount()).thenReturn(3000);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showAdvStatistics(statisticsMock);
        //Then
        assertEquals(200, statisticsCalculator.getPostsCount());
        assertEquals(3000, statisticsCalculator.getCommentsCount());
        assertEquals(0.4, statisticsCalculator.getAvgPostsPerUser(), 0.01);
        assertEquals(6, statisticsCalculator.getAvgCommentsPerUser(), 0.01);
        assertEquals(15, statisticsCalculator.getAvgCommentsPerPost(), 0.01);

    }

    @Test // unit test 6
    public void testCalculateAdvStatistics_T06_WhenUsersCount0(){

        System.out.println("testCalculateAdvStatistics_T06_WhenUsersCount0");

        //Given
        when(statisticsMock.usersNames()).thenReturn(generateUsers(0));
        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.commentsCount()).thenReturn(40);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, statisticsCalculator.getUsersCount());
        assertEquals(0, statisticsCalculator.getAvgPostsPerUser(), 0.01);
        assertEquals(0, statisticsCalculator.getAvgCommentsPerUser(), 0.01);

    }

    @Test // unit test 7
    public void testCalculateAdvStatistics_T07_WhenUsersCount100(){

        System.out.println("testCalculateAdvStatistics_T07_WhenUsersCount100");

        //Given
        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.commentsCount()).thenReturn(40);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, statisticsCalculator.getUsersCount());
        assertEquals(0.2, statisticsCalculator.getAvgPostsPerUser(), 0.01);
        assertEquals(0.4, statisticsCalculator.getAvgCommentsPerUser(), 0.01);

    }

}