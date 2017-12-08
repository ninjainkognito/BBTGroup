package com.ara.bbtgroup.model;

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
    private Integer contactId;

    private String header;
    private String contactType;
    private Date date;
    private Time time;
    private String desription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id_fk")
    private Employee ownerOfTheContact;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Contact(){
        super();
    }

    public Contact(String header, String contactType, Date date, Time time, String desription, Employee ownerOfTheContact) {
        this.header = header;
        this.contactType = contactType;
        this.date = date;
        this.time = time;
        this.desription = desription;
        this.ownerOfTheContact = ownerOfTheContact;
    }




    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public Employee getOwnerOfTheContact() {
        return ownerOfTheContact;
    }

    public void setOwnerOfTheContact(Employee ownerOfTheContact) {
        this.ownerOfTheContact = ownerOfTheContact;
    }
}
