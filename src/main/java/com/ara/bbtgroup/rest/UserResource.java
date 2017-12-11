package com.ara.bbtgroup.rest;


import com.ara.bbtgroup.model.User;
import com.ara.bbtgroup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(ResourceConstants.USER_V1)
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    // ======================================
    // =             GET METHOD             =
    // ======================================

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<User> getAllUsers() {

        return (List<User>) userRepository.findAll();
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {

        return new ResponseEntity<>(userRepository.findByUsername(username), HttpStatus.OK);
    }

    // ======================================
    // =             POST METHOD            =
    // ======================================

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User userRequest){

        if(userRequest == null || userRequest.getUsername() == "" || userRequest.getUsername() == "null"){
            return new ResponseEntity<User>(userRequest, HttpStatus.CREATED);
        }
        else{
            userRepository.save(userRequest);
            return new ResponseEntity<User>(userRequest, HttpStatus.CREATED);
        }
    }

    // ======================================
    // =             PUT METHOD             =
    // ======================================

    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> updateUser(
            @RequestBody User userRequest) {

        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }

    // ======================================
    // =          DELETE METHOD             =
    // ======================================

    @RequestMapping(path = "/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {

        userRepository.delete(userId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
