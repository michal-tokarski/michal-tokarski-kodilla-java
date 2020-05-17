package com.kodilla.patterns.strategy.social;

public class User {

    final private String userName;
    protected SocialPublisher socialPublisher;

    public User(String userName) {
        this.userName = userName;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public void setDefaultPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public void setCustomPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String getUserName() {
        return userName;
    }

    public SocialPublisher getSocialPublisher() {
        return socialPublisher;
    }
}
