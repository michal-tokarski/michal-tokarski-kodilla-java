package com.kodilla.patterns.strategy.social;

public class SnapchatPublisher implements SocialPublisher {

    private String socialPublisherName = "Snapchat";

    @Override
    public String share() {
        return "This message has been shared via " + socialPublisherName;
    }

}
