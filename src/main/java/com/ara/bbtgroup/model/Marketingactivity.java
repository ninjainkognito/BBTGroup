package com.ara.bbtgroup.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "marketingactivity")
public class Marketingactivity {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long marketingactivityId;

    private String title;

    private String extraInfo;

    private String comment;

    @Temporal(TemporalType.DATE)
    private Date startDate = new Date();

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Range(min = 1, max = 3)
    private int status;

    private int employeeId;


    // ======================================
    // =            Constructors            =
    // ======================================

    public Marketingactivity(){
        super();
    }

    public Marketingactivity(String title, String extraInfo, String comment,
                             Date startDate, Date endDate, int status, int employeeId) {
        this.title = title;
        this.extraInfo = extraInfo;
        this.comment = comment;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.employeeId = employeeId;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================


    public Long getMarketingactivityId() {
        return marketingactivityId;
    }

    public void setMarketingactivityId(Long marketingactivityId) {
        this.marketingactivityId = marketingactivityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
