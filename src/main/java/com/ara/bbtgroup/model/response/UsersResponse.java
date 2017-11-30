package com.ara.bbtgroup.model.response;

public class UsersResponse {

    private Integer id;
    private String firstname;
    private String lastname;

    public UsersResponse() {
        super();
    }

    public UsersResponse(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

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
