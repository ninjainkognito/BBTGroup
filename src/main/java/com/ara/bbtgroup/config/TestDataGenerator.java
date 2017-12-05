package com.ara.bbtgroup.config;

import com.ara.bbtgroup.entities.User;
import com.ara.bbtgroup.entities.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TestDataGenerator {

    private UserRepository userRepository;

    private User user;
    private User user2;
    private User user3;

    public TestDataGenerator(){
        this.user = new User("Testuser1", "AAAAA");
        this.user2 = new User("Testuser2", "AAAAA");
        this.user3 = new User("Testuser3", "AAAAA");
    }

    public void generateUser(){
        User user;
        User user2;
        User user3;

        user = new User("Testuser1", "AAAAA");
        user2 = new User("Testuser2", "AAAAA");
        user3 = new User("Testuser3", "AAAAA");

        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
