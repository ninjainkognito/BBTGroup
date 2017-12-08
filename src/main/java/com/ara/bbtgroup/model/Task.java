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
    @Column(name = "task_status")
    private boolean taskStatus;
    private Date taskbegin;
    private Date taskend;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id_fk")
    private Employee ownerOfTheTask;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Task(){
        super();
    }

    public Task(String header, boolean taskStatus, Date taskbegin, Date taskend, String description, Employee ownerOfTheTask) {
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

    public boolean isTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
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

    public Employee getOwnerOfTheTask() {
        return ownerOfTheTask;
    }

    public void setOwnerOfTheTask(Employee ownerOfTheTask) {
        this.ownerOfTheTask = ownerOfTheTask;
    }
}
