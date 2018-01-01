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

    @Range(min = 1)
    private int employeId;

    // @ManyToOne
    // private Employee employee;

    @Range(min = 1)
    private int customerId;

    // @ManyToOne
    // private Customer customer;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Contact(){
        super();
    }

    public Contact(String header, String contactType, String desription) {
        this.header = header;
        this.contactType = contactType;
        this.desription = desription;;
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
