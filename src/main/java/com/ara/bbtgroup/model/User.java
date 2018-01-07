package com.ara.bbtgroup.model;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bbtgroup_user")
public class User {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @Column(name= "user_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotNull
    @Column
    private String username;

    @NotNull
    @Column
    private String password;

    // ======================================
    // =            Constructors            =
    // ======================================

    public User(){
        super();
    }

    public User(String username, String password) {
        this.username = username;
        setPassword(password);
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
        return this.password;
    }

    public void setPassword(String password) {
        this.password = generateHashFromInput(password);
    }

    public String generateHashFromInput(String input){
        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

        String hashedPassword = passwordEncoder.encodePassword(input, null);
        return hashedPassword;
    }
}
