package com.kodilla.patterns2.observer.homework;

public enum CourseAssignment {

    JAVA_DEV_24_1("11","24.1 - Facade Pattern"),
    JAVA_DEV_24_2("12","24.2 - Decorator Pattern"),
    JAVA_DEV_24_3("13","24.3 - Aspects Programming"),
    JAVA_DEV_24_4("14","24.4 - Observer Pattern"),
    JAVA_DEV_24_5("15","24.5 - Adapter Pattern"),
    JAVA_DEV_24_X("16","24.X - Extra Task"),

    WEB_DEV_14_1("21","14.1 - React Application"),
    WEB_DEV_14_2("22","14.2 - Javascript Dependencies"),

    PYTHON_DEV_31_1("31","31.1 - Calculator Tool"),
    PYTHON_DEV_31_2("32","31.2 - eCommerce Platform"),
    PYTHON_DEV_31_3("33","31.3 - Flight Searcher");


    private String courseAssignmentId;
    private String name;

    CourseAssignment(String courseAssignmentId, String name) {
        this.courseAssignmentId = courseAssignmentId;
        this.name = name;
    }

}
