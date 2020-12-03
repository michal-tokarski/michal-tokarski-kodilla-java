package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class PipelineAssignment {

    private String pipelineAssignmentId;
    private CourseAssignment courseAssignment;
    private Boolean isNew;
    private Boolean isReviewed;
    private List<Message> messages;

    public PipelineAssignment(String pipelineAssignmentId, CourseAssignment courseAssignment, Boolean isNew, Boolean isReviewed) {
        this.pipelineAssignmentId = pipelineAssignmentId;
        this.courseAssignment = courseAssignment;
        this.isNew = isNew;
        this.isReviewed = isReviewed;
        messages = new ArrayList<>();
    }

    public String getPipelineAssignmentId() {
        return pipelineAssignmentId;
    }

    public CourseAssignment getGourseAssignment () {
        return courseAssignment;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public Boolean getIsReviewed() {
        return isReviewed;
    }

    public void setIsReviewed(Boolean reviewed) {
        isReviewed = reviewed;
    }

}
