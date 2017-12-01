package com.ara.bbtgroup.rest;


import com.ara.bbtgroup.model.response.UsersResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ResourceConstants.EMPLOYEE_V1)
public class UserResource {

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UsersResponse> getEmployee() {

        return new ResponseEntity<>(new UsersResponse("Test", "Test"),HttpStatus.OK);
    }
}
