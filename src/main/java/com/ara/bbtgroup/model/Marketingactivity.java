package com.ara.bbtgroup.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "marketingactivity")
public class Marketingactivity {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @Column(name = "marketingactivity_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer marketingactivityId;

    private String header;
    private Date generationDate;
    private String description;
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id_fk")
    private Employee ownerOfTheMarketingactivity;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Marketingactivity(){
        super();
    }

    public Marketingactivity(String header, Date generationDate, String description, boolean status, Employee ownerOfTheMarketingactivity) {
        this.header = header;
        this.generationDate = generationDate;
        this.description = description;
        this.status = status;
        this.ownerOfTheMarketingactivity = ownerOfTheMarketingactivity;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Integer getMarketingactivityId() {
        return marketingactivityId;
    }

    public void setMarketingactivityId(Integer marketingactivityId) {
        this.marketingactivityId = marketingactivityId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Employee getOwnerOfTheMarketingactivity() {
        return ownerOfTheMarketingactivity;
    }

    public void setOwnerOfTheMarketingactivity(Employee ownerOfTheMarketingactivity) {
        this.ownerOfTheMarketingactivity = ownerOfTheMarketingactivity;
    }
}
