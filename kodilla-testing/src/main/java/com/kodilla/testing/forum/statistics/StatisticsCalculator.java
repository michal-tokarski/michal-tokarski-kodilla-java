package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {

    Statistics statistics;

    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;


    public StatisticsCalculator(Statistics statistics) {
        this.statistics = statistics;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }

    private double calculateAvgPostsPerUser() {
        if(usersCount>0){
            return (double)postsCount/usersCount;
        } else {
            return 0;
        }
    }

    private double calculateAvgCommentsPerUser() {
        if(usersCount>0){
            return (double)commentsCount/usersCount;
        } else {
            return 0;
        }
    }

    private double calculateAvgCommentsPerPost() {
        if(postsCount>0){
            return (double)commentsCount/postsCount;
        } else {
            return 0;
        }
    }

    public void calculateAdvStatistics(Statistics statistics){

        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();

        avgPostsPerUser = calculateAvgPostsPerUser();
        avgCommentsPerUser = calculateAvgCommentsPerUser();
        avgCommentsPerPost = calculateAvgCommentsPerPost();

    }

    public void showAdvStatistics(Statistics statisticsMock){

        System.out.println("Advanced statistics :");
        System.out.println("1. Users count......................: " + usersCount);
        System.out.println("2. Posts count......................: " + postsCount);
        System.out.println("3. Comments count...................: " + commentsCount);
        System.out.println("4. Avg Posts per user...............: " + avgPostsPerUser);
        System.out.println("5. Avg Comments per user............: " + avgCommentsPerUser);
        System.out.println("6. Avg Comments per post............: " + avgCommentsPerPost);

    }

    public static void main(String[] args) {

        ExampleStatistics myExample = new ExampleStatistics ();
        StatisticsCalculator myCalculator = new StatisticsCalculator (myExample);

        myCalculator.calculateAdvStatistics(myExample);
        myCalculator.showAdvStatistics(myExample);

    }

}
