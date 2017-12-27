package com.ara.bbtgroup.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bbtgroup_user")
public class User {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @Column(name= "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotNull
    @Column
    private String username;

    @NotNull
    @Column
    private String password;

    @OneToOne(mappedBy = "user")
    private Employee employee;


    // ======================================
    // =            Constructors            =
    // ======================================

    public User(){
        super();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    @OneToOne(mappedBy = "usercredential")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployeeInformation(Employee employeeInformation) {
        this.employee = employeeInformation;
    }
}
