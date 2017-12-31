package com.ara.bbtgroup.model;

import org.hibernate.annotations.CreationTimestamp;

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

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Customer customer;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Contact(){
        super();
    }

    public Contact(String header, String contactType, String desription, Employee employee, Customer customer) {
        this.header = header;
        this.contactType = contactType;
        this.desription = desription;
        this.employee = employee;
        this.customer = customer;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
