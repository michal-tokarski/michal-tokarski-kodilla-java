package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Period;

public class ForumUser {

    private int numberOfPosts;
    private int userId;
    private String userName;
    private char sex;
    private LocalDate birthdate;

    public ForumUser(int userId, String userName, char sex, LocalDate birthdate, int numberOfPosts) {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.birthdate = birthdate;
        this.numberOfPosts = numberOfPosts;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getCurrentAge() {
        return Period.between( getBirthdate(), LocalDate.now() ).getYears();
    }

    @Override
    public String toString() {
        return "ForumUser {" +
                "UserId - " + userId + " ; " +
                "UserName - " + userName + " ; " +
                "Sex - " + sex + " ; " +
                "Birthdate - " + birthdate + " ; " +
                "CurrentAge - " + getCurrentAge() + " ; " +
                "NoOfPosts - " + numberOfPosts +
                '}';
    }
}
