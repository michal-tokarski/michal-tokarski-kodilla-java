package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Bean
    public Board createBoard() {
        return new Board(taskList_ToDo, taskList_InProgress, taskList_Done);
    }

    @Autowired
    @Qualifier("taskList_ToDo")
    TaskList taskList_ToDo;

    @Autowired
    @Qualifier("taskList_InProgress")
    TaskList taskList_InProgress;

    @Autowired
    @Qualifier("taskList_Done")
    TaskList taskList_Done;

    @Bean(name = "taskList_ToDo")
    @Scope("prototype")
    public TaskList getTaskList_ToDo() {
        return new TaskList();
    }

    @Bean(name = "taskList_InProgress")
    @Scope("prototype")
    public TaskList getTaskList_InProgress() {
        return new TaskList();
    }

    @Bean(name = "taskList_Done")
    @Scope("prototype")
    public TaskList getTaskList_Done() {
        return new TaskList();
    }

}
