package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.Task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TASKLISTS")
public final class TaskList {

    private int id;
    private String listName;
    private String description;
    private List<Task> pureTaskList = new ArrayList<>(); // additional field
    private List<Task> tasks = new ArrayList<>();

    public TaskList() {
    }

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    /*
    // temporarily commented out
    // error message : " 'Basic' attribute should not be a container "
    public List<Task> getPureTaskList() {
        return pureTaskList;
    }
    */

    @OneToMany(
        targetEntity = Task.class,
        mappedBy = "taskList",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    public List<Task> getTasks() {
        return tasks;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    /*
    // temporarily commented out
    // corresponding to the getPureTaskList() above
    public void setPureTaskList(List<Task> pureTaskList) {
        this.pureTaskList = pureTaskList;
    }
    */

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
