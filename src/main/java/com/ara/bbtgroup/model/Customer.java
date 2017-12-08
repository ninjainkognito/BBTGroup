package com.ara.bbtgroup.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @Column(name = "customer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private Integer zipcode;
    private String country;
    private String email;
    private String phonenumber;
    private Date birth;
    private boolean newsletter;
    private String important_textfield;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "geolocation_id_fk")
    private Geolocation customerGeolocation;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Customer(){
        super();
    }

    public Customer(String firstname, String lastname, String address,
                    String city, Integer zipcode, String country, String email,
                    String phonenumber, Date birth, boolean newsletter,
                    String important_textfield, Geolocation customerGeolocation) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
        this.email = email;
        this.phonenumber = phonenumber;
        this.birth = birth;
        this.newsletter = newsletter;
        this.important_textfield = important_textfield;
        this.customerGeolocation = customerGeolocation;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public String getImportant_textfield() {
        return important_textfield;
    }

    public void setImportant_textfield(String important_textfield) {
        this.important_textfield = important_textfield;
    }

    public Geolocation getCustomerGeolocation() {
        return customerGeolocation;
    }

    public void setCustomerGeolocation(Geolocation customerGeolocation) {
        this.customerGeolocation = customerGeolocation;
    }
}
