package com.ara.bbtgroup.entities;

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

    @Column
    private String firstname;
    @Column
    private String lastname;

    // ======================================
    // =            Constructors            =
    // ======================================

    public User(){
        super();
    }

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
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

    // ======================================
    // =     equals, hashCode & to String   =
    // ======================================

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
