package com.ara.bbtgroup.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "contact")
public class Contact {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @Column(name= "contact_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactId;

    private String header;

    private String contactType;

    @Temporal(TemporalType.DATE)
    private Date date = new Date();
    
    @Temporal (TemporalType.TIME)
    private Date time = new Date();

    private String desription;

    private int employeId;

    private int customerId;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Contact(){
        super();
    }

    public Contact(String header, String contactType,
                   Date date, Date time, String desription,
                   int employeId, int customerId) {
        this.header = header;
        this.contactType = contactType;
        this.date = date;
        this.time = time;
        this.desription = desription;
        this.employeId = employeId;
        this.customerId = customerId;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public int getEmployeId() {
        return employeId;
    }

    public void setEmployeId(int employeId) {
        this.employeId = employeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
