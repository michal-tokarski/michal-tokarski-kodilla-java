package com.kodilla.patterns2.observer.homework;

public class Student implements Observer {

    private String studentId;
    private String firstName;
    private String lastName;
    private int newAssignmentsCount = 0;
    private int reviewedAssignmentsCount = 0;

    public Student(String studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student {" + firstName + " " + lastName + "}";
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public void updateNew(Pipeline pipeline) {
        String message
                = "To : " + getFirstName() + getLastName() + " : "
                + "A new assignment has been posted in - " + pipeline.toString()
                + "(total new : " + pipeline.getNewAssignmentsCount() + ")";
        System.out.println(message);
        newAssignmentsCount++;
    }

    @Override
    public void updateReviewed(Pipeline pipeline) {
        String message
                = "To : " + getFirstName() + getLastName() + " : "
                + "An assignment has been reviewed in - " + pipeline.toString()
                + "(total reviewed : " + pipeline.getReviewedAssignmentsCount() + ")";
        System.out.println(message);
        reviewedAssignmentsCount++;
    }

    public int getNewAssignmentsCount() {
        return newAssignmentsCount;
    }

    public int getReviewedAssignmentsCount() {
        return reviewedAssignmentsCount;
    }

}
