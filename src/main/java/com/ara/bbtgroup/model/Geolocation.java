package com.ara.bbtgroup.model;

import javax.persistence.*;

@Entity
@Table(name = "geolocation")
public class Geolocation {

    // ======================================
    // =             Attributes             =
    // ======================================

    // AIzaSyBF_iPPbbY7UgRGc11Az2XnF2YAJSak2OY

    @Id
    @Column(name = "geolocation_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long geolocationId;

    private String latleng;
    private String name;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Geolocation() {
        super();
    }

    public Geolocation(String latleng, String name) {
        this.latleng = latleng;
        this.name = name;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getGeolocationId() {
        return this.geolocationId;
    }

    public void setGeolocationId(Long geolocationId) {
        this.geolocationId = geolocationId;
    }

    public String getLatleng() {
        return latleng;
    }

    public void setLatleng(String latleng) {
        this.latleng = latleng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
