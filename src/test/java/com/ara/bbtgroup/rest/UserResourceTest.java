package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.model.User;
import com.ara.bbtgroup.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.lang.Long.valueOf;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserResourceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser_whenFoundById_thenOk(){

        User user = userRepository.save(new User("testuser", "123456"));

        User userFound = userRepository
                .findOne(user.getUserId());

        assertNotNull(userFound);
        assertEquals(user.getUserId(), userFound.getUserId());
    }

    @Test
    public void saveMultipleUser_AndFindAll_whenMultipleFound_thenOk(){

        User user = new User("testuser1", "123456");
        User user1 = new User("testuser2", "123456");
        User user2 = new User("testuser3", "123456");

        this.userRepository.save(user);
        this.userRepository.save(user1);
        this.userRepository.save(user2);

        List<User> userList = (List<User>) userRepository.findAll();

        assertNotNull(userList);
        // assertTrue(userList.size() > 0);
    }

    @Test
    public void saveUserAndDelete_whenDeleted_thenOk(){

        User user = userRepository.save(new User("testuser4", "123456"));

        assertEquals(user.getUserId(), userRepository.findByUsername("testuser4").getUserId());

        Long lastInsertUser = userRepository.findOne(user.getUserId()).getUserId();
        userRepository.delete(lastInsertUser);
        assertNull(userRepository.findOne(lastInsertUser));
    }

    @Test
    public void updateTask_whenUpdated_thenOk(){
        User user = userRepository
                .save(new User("testuser5", "123456"));

        User userUpdate = userRepository.findOne(user.getUserId());
        userUpdate.setUsername("AAAA");

        userRepository.save(userUpdate);

        assertEquals(userRepository.findOne(userUpdate.getUserId()).getUserId(), user.getUserId());
    }
}
