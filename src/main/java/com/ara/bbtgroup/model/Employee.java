package com.ara.bbtgroup.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "employee")
public class Employee {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @Column(name= "employee_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private Integer zipcode;
    private String country;
    private String employeeRole;
    private String email;
    private String phonenumber;
    private String birth;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    /*
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Task> tasks;
    */

    // @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    // private List<Contact> contacts = new ArrayList<Contact>();

    // @OneToMany(mappedBy = "ownerOfTheMarketingactivity")
    // private List<Marketingactivity> marketingactivities;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Employee() {
        super();
    }

    public Employee(String firstname, String lastname, String address, String city,
                    Integer zipcode, String country, String employeeRole, String email,
                    String phonenumber, String birth, User user) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
        this.employeeRole = employeeRole;
        this.email = email;
        this.phonenumber = phonenumber;
        this.birth = birth;
        this.user = user;
    }

// ======================================
    // =          Getters & Setters         =
    // ======================================


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getBirthdate() {
        return birth;
    }

    public void setBirthdate(String birth) {
        this.birth = birth;
    }

    public User getUser() {
        return user;
    }

    public void setUsercredential(User user) {
        this.user = user;
    }
}
