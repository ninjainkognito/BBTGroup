package com.ara.bbtgroup.model;

import javax.persistence.*;

@Entity
@Table(name = "bbtgroup_user")
public class User {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @Column(name= "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column
    private String username;

    @Column
    private String password;

    @OneToOne(fetch=FetchType.LAZY, mappedBy="usercredential")
    private Employee employeeInformation;

    // ======================================
    // =            Constructors            =
    // ======================================

    public User(){
        super();
    }

    public User(String username, String password, Employee employeeInformation) {
        this.username = username;
        this.password = password;
        this.employeeInformation = employeeInformation;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployeeInformation() {
        return employeeInformation;
    }

    public void setEmployeeInformation(Employee employeeInformation) {
        this.employeeInformation = employeeInformation;
    }
}
