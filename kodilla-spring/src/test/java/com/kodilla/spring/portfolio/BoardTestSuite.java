package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class BoardTestSuite {


    @Test
    public void testTaskAdd_v1() {

        //Given
        String taskName_ToDo = "Prepare plan";
        String taskName_InProgress = "Continue rollout";
        String taskName_Done = "Close project";

        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        // Board board_bean = context.getBean(Board.class); /* looks unnecessary */

        //When
        TaskList taskList_ToDo_bean = (TaskList) context.getBean("taskList_ToDo");
        taskList_ToDo_bean.addTask(taskName_ToDo);

        TaskList taskList_InProgress_bean = (TaskList) context.getBean("taskList_InProgress");
        taskList_InProgress_bean.addTask(taskName_InProgress);

        TaskList taskList_Done_bean = (TaskList) context.getBean("taskList_Done");
        taskList_Done_bean.addTask(taskName_Done);

        //Then
        System.out.println(taskList_ToDo_bean);
        System.out.println(taskList_InProgress_bean);
        System.out.println(taskList_Done_bean);

        Assert.assertEquals(taskName_ToDo, taskList_ToDo_bean.getTaskList().get(0));
        Assert.assertEquals(taskName_InProgress, taskList_InProgress_bean.getTaskList().get(0));
        Assert.assertEquals(taskName_Done, taskList_Done_bean.getTaskList().get(0));

    }

    @Test
    public void testTaskAdd_v2() {

        //Given
        String taskName_ToDo = "Design the house";
        String taskName_InProgress = "Continue construction";
        String taskName_Done = "Get approval from authorities";

        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board_bean = context.getBean(Board.class);

        //When
        TaskList taskList_ToDo_bean = board_bean.getTaskList_ToDo();
        taskList_ToDo_bean.addTask(taskName_ToDo);

        TaskList taskList_InProgress_bean = board_bean.getTaskList_InProgress();
        taskList_InProgress_bean.addTask(taskName_InProgress);

        TaskList taskList_Done_bean = board_bean.getTaskList_Done();
        taskList_Done_bean.addTask(taskName_Done);

        //Then
        System.out.println(taskList_ToDo_bean);
        System.out.println(taskList_InProgress_bean);
        System.out.println(taskList_Done_bean);

        Assert.assertEquals(taskName_ToDo, taskList_ToDo_bean.getTaskList().get(0));
        Assert.assertEquals(taskName_InProgress, taskList_InProgress_bean.getTaskList().get(0));
        Assert.assertEquals(taskName_Done, taskList_Done_bean.getTaskList().get(0));

    }
}
