package com.ara.bbtgroup.model;

import javax.persistence.*;

@Entity
@Table(name = "geolocation")
public class Geolocation {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @Column(name = "geolocation_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer geolocationId;

    private Float latitude;
    private Float longitude;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id_fk")
    private Customer customer;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Geolocation() {
        super();
    }

    public Geolocation(Float latitude, Float longitude, Customer customer) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.customer = customer;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Integer getGeolocationId() {
        return geolocationId;
    }

    public void setGeolocationId(Integer geolocationId) {
        this.geolocationId = geolocationId;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
