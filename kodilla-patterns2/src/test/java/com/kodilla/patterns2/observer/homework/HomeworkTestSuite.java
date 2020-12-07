/*
-------------------------------------------------------------------------------------------
Task 24.4.
1. Utwórz pakiet com.kodilla.patterns2.observer.homework zarówno w katalogu src/main/java,
   jak i w katalogu src/test/java.
2. Następnie trzeba stworzyć klasę reprezentującą kolejkę zadań kursanta implementującą interfejs
   utworzony według zasad właściwych dla Observable,
3. W kolejnym kroku utwórz klasę reprezentującą mentora,
   implementującą interfejs stworzony według zasad właściwych dla Observer
4. Stwórz test, a w nim utwórz kilka kolejek zadań kursantów oraz dwóch mentorów.
   Zasubskrybuj mentorów na powiadomienia o nowych zadaniach w kolejce.
   Test powinien sprawdzać czy całość działa poprawnie.
   -------------------------------------------------------------------------------------------
 */

package com.kodilla.patterns2.observer.homework;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class HomeworkTestSuite {

    public Student student1, student2, student3, student4, student5;
    public Pipeline pipeline1, pipeline2, pipeline3, pipeline4, pipeline5;
    public Mentor mentor1, mentor2, mentorC;
    public PipelineAssignment pipelineAssignment1, pipelineAssignment2, pipelineAssignment3, pipelineAssignment4, pipelineAssignment5, pipelineAssignment6;

    @Before
    public void test0_Initialize() {

        System.out.println("\n");
        System.out.println("test0_Initialize" + " : ");

        // Given
        // Create students :
        student1 = new Student("1", "Ksawery", "Wesoly");
        student2 = new Student("2", "Zenon", "Laskowik");
        student3 = new Student("3", "James", "Dean");
        student4 = new Student("4", "Henryk", "Zapominalski");
        student5 = new Student("5", "Antoni", "Niezwykly");

        // Given
        // Create pipelines :
        pipeline1 = new Pipeline ("1", student1, Course.JAVA_DEVELOPER_COURSE);
        pipeline2 = new Pipeline ("2", student2, Course.JAVA_DEVELOPER_COURSE);
        pipeline3 = new Pipeline ("3", student3, Course.JAVA_DEVELOPER_COURSE);
        pipeline4 = new Pipeline ("4", student4, Course.JAVA_DEVELOPER_COURSE);
        pipeline5 = new Pipeline ("5", student5, Course.JAVA_DEVELOPER_COURSE);

        // Given
        // Create mentors :
        mentor1 = new Mentor("1", "Piotr", "Wielki");
        mentor2 = new Mentor("2", "George", "Patton");
        mentorC = new Mentor("3", "Mentor", "Coordinator");

        // Given
        // Create assignments :
        pipelineAssignment1 = new PipelineAssignment("1", CourseAssignment.JAVA_DEV_24_1, true, false);
        pipelineAssignment2 = new PipelineAssignment("2", CourseAssignment.JAVA_DEV_24_2, true, false);
        pipelineAssignment3 = new PipelineAssignment("3", CourseAssignment.JAVA_DEV_24_3, true, false);
        pipelineAssignment4 = new PipelineAssignment("4", CourseAssignment.JAVA_DEV_24_4, true, false);
        pipelineAssignment5 = new PipelineAssignment("5", CourseAssignment.JAVA_DEV_24_5, true, false);
        pipelineAssignment6 = new PipelineAssignment("6", CourseAssignment.JAVA_DEV_24_X, true, false);

        // Given
        // Subscribe students to their pipelines :
        pipeline1.subscribeObserver(student1);
        pipeline2.subscribeObserver(student2);
        pipeline3.subscribeObserver(student3);
        pipeline4.subscribeObserver(student4);
        pipeline5.subscribeObserver(student5);

        // Given
        // Subscribe mentors to students' pipelines :
        pipeline1.subscribeObserver(mentor1); pipeline1.subscribeObserver(mentor2); pipeline1.subscribeObserver(mentorC);
        pipeline2.subscribeObserver(mentorC);
        pipeline3.subscribeObserver(mentor2); pipeline3.subscribeObserver(mentorC);
        pipeline4.subscribeObserver(mentor1); pipeline4.subscribeObserver(mentorC);
        pipeline5.subscribeObserver(mentor1); pipeline5.subscribeObserver(mentor2); pipeline5.subscribeObserver(mentorC);

    }

    @Test
    public void test1_AddNewAssignments() {

        System.out.println("\n");
        System.out.println("test1_AddNewAssignments" + " : ");

        // When
        // Add students' assignments to pipelines :
        pipeline1.addAssignment(pipelineAssignment3); pipeline1.addAssignment(pipelineAssignment1);
        pipeline2.addAssignment(pipelineAssignment2);
        pipeline3.addAssignment(pipelineAssignment1); pipeline3.addAssignment(pipelineAssignment3); pipeline3.addAssignment(pipelineAssignment4);
        pipeline4.addAssignment(pipelineAssignment1);
        pipeline5.addAssignment(pipelineAssignment2); pipeline5.addAssignment(pipelineAssignment5);

        // Then
        System.out.println("\n");
        System.out.println("Check if all mentors received correct no. of notifications of all new assignments :");
        System.out.println(mentor1.toString() + " : " +  "No. of new assignments - " + mentor1.getNewAssignmentsCount());
        System.out.println(mentor2.toString() + " : " +  "No. of new assignments - " + mentor2.getNewAssignmentsCount());
        System.out.println(mentorC.toString() + " : " +  "No. of new assignments - " + mentorC.getNewAssignmentsCount());
        assertEquals(5, mentor1.getNewAssignmentsCount());
        assertEquals(7, mentor2.getNewAssignmentsCount());
        assertEquals(9, mentorC.getNewAssignmentsCount());

    }

    @Test
    public void test2_ReviewAssignments() {

        System.out.println("\n");
        System.out.println("test2_ReviewAssignments" + " : ");

        // When
        // Review students' assignments by mentors :
        pipeline1.reviewAssignment(pipelineAssignment3); // pipeline1.reviewAssignment(pipelineAssignment1);
        pipeline2.reviewAssignment(pipelineAssignment2);
        pipeline3.reviewAssignment(pipelineAssignment1); pipeline3.reviewAssignment(pipelineAssignment3); // pipeline3.reviewAssignment(pipelineAssignment4);
        // pipeline4.reviewAssignment(pipelineAssignment1);
        pipeline5.reviewAssignment(pipelineAssignment2); pipeline5.reviewAssignment(pipelineAssignment5);

        // Then
        System.out.println("\n");
        System.out.println("Check if all students received correct no. of notifications of all assignments that have been reviewed :");
        System.out.println(student1.toString() + " : " +  "No. of reviewed assignments - " + student1.getReviewedAssignmentsCount());
        System.out.println(student2.toString() + " : " +  "No. of reviewed assignments - " + student2.getReviewedAssignmentsCount());
        System.out.println(student3.toString() + " : " +  "No. of reviewed assignments - " + student3.getReviewedAssignmentsCount());
        System.out.println(student4.toString() + " : " +  "No. of reviewed assignments - " + student4.getReviewedAssignmentsCount());
        System.out.println(student5.toString() + " : " +  "No. of reviewed assignments - " + student5.getReviewedAssignmentsCount());
        assertEquals(1, student1.getReviewedAssignmentsCount());
        assertEquals(1, student2.getReviewedAssignmentsCount());
        assertEquals(2, student3.getReviewedAssignmentsCount());
        assertEquals(0, student4.getReviewedAssignmentsCount());
        assertEquals(2, student5.getReviewedAssignmentsCount());

    }

}
