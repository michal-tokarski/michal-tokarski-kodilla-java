package com.kodilla.spring.portfolio;

public class Board {

    private TaskList taskList_ToDo;
    private TaskList taskList_InProgress;
    private TaskList taskList_Done;

    public Board(TaskList taskList_ToDo, TaskList taskList_InProgress, TaskList taskList_Done) {
        this.taskList_ToDo = taskList_ToDo;
        this.taskList_InProgress = taskList_InProgress;
        this.taskList_Done = taskList_Done;
    }

    public TaskList getTaskList_ToDo() {
        return taskList_ToDo;
    }

    public TaskList getTaskList_InProgress() {
        return taskList_InProgress;
    }

    public TaskList getTaskList_Done() {
        return taskList_Done;
    }
}
