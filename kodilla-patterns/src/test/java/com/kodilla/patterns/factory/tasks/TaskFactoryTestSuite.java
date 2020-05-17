package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.makeTask(TaskFactory.TaskType.DRIVING_TASK);
        //Then
        Assert.assertEquals("Drive to doctor", drivingTask.getTaskName()); // check taskName
        drivingTask.executeTask();
        Assert.assertTrue(drivingTask.isTaskExecuted()); // check isTaskExecuted

    }

    @Test
    public void testPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.makeTask(TaskFactory.TaskType.PAINTING_TASK);
        //Then
        Assert.assertEquals("Paint with anitcorrosive", paintingTask.getTaskName()); // check taskName
        paintingTask.executeTask();
        Assert.assertTrue(paintingTask.isTaskExecuted()); // check isTaskExecuted

    }

    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask(TaskFactory.TaskType.SHOPPING_TASK);
        //Then
        Assert.assertEquals("Buy weekly food", shoppingTask.getTaskName()); // check taskName
        shoppingTask.executeTask();
        Assert.assertTrue(shoppingTask.isTaskExecuted()); // check isTaskExecuted

    }

}
