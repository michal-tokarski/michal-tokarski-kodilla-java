package com.kodilla.patterns2.observer.homework;

import java.time.LocalDate;

public class Message {

    private LocalDate date;
    private String sendTo;
    private String copyTo;
    private String body;

    public Message(String body) {
        this.body = body;
    }

}
