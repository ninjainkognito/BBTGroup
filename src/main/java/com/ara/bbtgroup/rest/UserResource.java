package com.ara.bbtgroup.rest;


import com.ara.bbtgroup.model.User;
import com.ara.bbtgroup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
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

        if (userRepository.findByUsername(username) == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(userRepository.findByUsername(username), HttpStatus.OK);
        }
    }

    @GetMapping(path = "/id/{username}/pass/{password}")
    public @ResponseBody ResponseEntity<User> checkUserData(@PathVariable String username, @PathVariable String password) {

        // code password into hash string
        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        String hashedPassword = passwordEncoder.encodePassword(password, null);

        User user = userRepository.checkCredential(username, hashedPassword);
        if (user.getPassword() != null)
        {
            return new ResponseEntity<User>(userRepository.checkCredential(username, hashedPassword), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // ======================================
    // =             POST METHOD            =
    // ======================================

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User userRequest){

        userRepository.save(userRequest);
        return new ResponseEntity<User>(userRequest, HttpStatus.CREATED);
    }

    // ======================================
    // =             PUT METHOD             =
    // ======================================

    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User userRequest) {

        userRepository.save(userRequest);
        return new ResponseEntity<User>(userRequest, HttpStatus.OK);
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
