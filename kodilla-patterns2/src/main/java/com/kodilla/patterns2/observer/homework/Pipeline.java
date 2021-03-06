package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Pipeline implements Observable {

    private String pipelineId;
    private Student student;
    private Course course;
    private List<PipelineAssignment> pipelineAssignments;
    private List<Observer> observers;
    private int newAssignmentsCount = 0;
    private int reviewedAssignmentsCount = 0;
    private List<String> messages;

    public Pipeline(String pipelineId, Student student, Course course) {
        this.pipelineId = pipelineId;
        this.student = student;
        this.course = course;
        pipelineAssignments = new ArrayList<>();
        observers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Pipeline {" + student.getFirstName() + " " + student.getLastName() + " / " + course + "}";
    }

    @Override
    public void subscribeObserver(Observer observer) {
        observers.add(observer);
        String message
                = "To : " + observer.getFirstName() + " " + observer.getLastName() + " : "
                + "You are subscribing now to - " + toString();
        System.out.println(message);
    }

    @Override
    public void notifyAllObservers(String actionType) {
        for (Observer observer : observers) {
            if (actionType.equals("new") ) {
                observer.updateNew(this);
            } else if (actionType.equals("reviewed")) {
                observer.updateReviewed(this);
            }
        }
    }

    @Override
    public void unsubscribeObserver(Observer observer) {
        observers.remove(observer);
        String message
                = "To : " + observer.getFirstName() + " " + observer.getLastName() + " : "
                + "You have just unsubscribed from - " + toString();
        System.out.println(message);
        messages.add(message);
    }

    public void addAssignment(PipelineAssignment pipelineAssignment){
        pipelineAssignments.add(pipelineAssignment);
        newAssignmentsCount++;
        notifyAllObservers("new");
    }

    public void reviewAssignment(PipelineAssignment pipelineAssignment){
        pipelineAssignment.setIsReviewed(true);
        reviewedAssignmentsCount++;
        notifyAllObservers("reviewed");
    }

    public int getNewAssignmentsCount() {
        return newAssignmentsCount;
    }

    public int getReviewedAssignmentsCount() {
        return reviewedAssignmentsCount;
    }
}
