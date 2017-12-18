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
        this.userId = userId;
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

    public Employee getEmployeeInformation() {
        return employeeInformation;
    }

    public void setEmployeeInformation(Employee employeeInformation) {
        this.employeeInformation = employeeInformation;
    }
}
