package com.ara.bbtgroup.model.request;

public class UserRequest {

    // ======================================
    // =             Attributes             =
    // ======================================

    private Integer id;
    private String firstname;
    private String lastname;

    // ======================================
    // =            Constructors            =
    // ======================================

    public UserRequest(Integer id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UserRequest(){
        super();
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
}
