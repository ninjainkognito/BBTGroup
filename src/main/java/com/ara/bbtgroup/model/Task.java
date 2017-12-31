package com.ara.bbtgroup.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @Column(name= "task_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    private String title;

    private String description;

    @Range(min = 1, max = 3)
    private int taskStatus;

    @Temporal(TemporalType.DATE)
    private Date taskbegin;

    @Temporal(TemporalType.DATE)
    private Date taskend;

    private Long ownerOfTheTask;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Task(){
        super();
    }

    public Task(String title, String description, int taskStatus, Date taskbegin, Date taskend, Long ownerOfTheTask) {
        this.title = title;
        this.description = description;
        this.taskStatus = taskStatus;
        this.taskbegin = taskbegin;
        this.taskend = taskend;
        this.ownerOfTheTask = ownerOfTheTask;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getTaskbegin() {
        return taskbegin;
    }

    public void setTaskbegin(Date taskbegin) {
        this.taskbegin = taskbegin;
    }

    public Date getTaskend() {
        return taskend;
    }

    public void setTaskend(Date taskend) {
        this.taskend = taskend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOwnerOfTheTask() {
        return ownerOfTheTask;
    }

    public void setOwnerOfTheTask(Long ownerOfTheTask) {
        this.ownerOfTheTask = ownerOfTheTask;
    }
}
