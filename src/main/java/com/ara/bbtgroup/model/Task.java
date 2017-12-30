package com.ara.bbtgroup.model;

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

    private String header;

    private Long taskStatus;

    @Temporal(TemporalType.DATE)
    private Date taskbegin;

    @Temporal(TemporalType.DATE)
    private Date taskend;

    private String description;

    private Long ownerOfTheTask;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Task(){
        super();
    }

    public Task(String header, Long taskStatus, Date taskbegin, Date taskend, String description, Long ownerOfTheTask) {
        this.header = header;
        this.taskStatus = taskStatus;
        this.taskbegin = taskbegin;
        this.taskend = taskend;
        this.description = description;
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

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Long getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Long taskStatus) {
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
