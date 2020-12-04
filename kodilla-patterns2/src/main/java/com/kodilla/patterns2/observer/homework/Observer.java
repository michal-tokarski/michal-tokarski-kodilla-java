package com.kodilla.patterns2.observer.homework;

public interface Observer {

    void updateNew(Pipeline pipeline);
    void updateReviewed(Pipeline pipeline);

    String getFirstName();
    String getLastName();

}
