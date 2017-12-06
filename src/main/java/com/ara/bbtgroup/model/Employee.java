package com.ara.bbtgroup.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;

    private String firstname;
    private String lastname;
    private String adddress;
    private String city;
    private Integer zipcode;
    private String country;
    private String employeeRole;
    private String email;
    private String phonenumber;
    private Date birthdate;
    private Integer fk_userId;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Employee(String firstname, String lastname, String adddress,
                    String city, Integer zipcode, String country, String employeeRole,
                    String email, String phonenumber, Date birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.adddress = adddress;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
        this.employeeRole = employeeRole;
        this.email = email;
        this.phonenumber = phonenumber;
        this.birthdate = birthdate;
    }

    public Employee() {
        super();
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
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

    public String getAdddress() {
        return adddress;
    }

    public void setAdddress(String adddress) {
        this.adddress = adddress;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

}
