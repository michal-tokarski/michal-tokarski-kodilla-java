package com.kodilla.patterns.strategy.social;

public class TwitterPublisher implements SocialPublisher {

    private String socialPublisherName = "Twitter";

    @Override
    public String share() {
        return "This message has been shared via " + socialPublisherName;
    }

}
