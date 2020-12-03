package com.kodilla.patterns2.observer.homework;

public enum Course {

    JAVA_DEVELOPER_COURSE("1","Java Developer Course"),
    WEB_DEVELOPER_COURSE("2","Web Developer Course"),
    PYTHON_DEVELOPER_COURSE("3","Python Developer Course");

    private String courseId;
    private String name;

    Course(String courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }

}
