package com.kodilla.patterns.strategy.social;

public class FacebookPublisher implements SocialPublisher {

    String socialPublisherName = "Facebook";

    @Override
    public String share() {
        return "This message has been shared via " + socialPublisherName;
    }

}
