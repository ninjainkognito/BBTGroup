package com.ara.bbtgroup.model;

import javax.persistence.*;

@Entity
@Table(name = "bbtgroup_user")
public class User {

    // ======================================
    // =             Attributes             =
    // ======================================


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    // ======================================
    // =     equals, hashCode & to String   =
    // ======================================

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
