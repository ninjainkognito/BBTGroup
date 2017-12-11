package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.model.Employee;
import com.ara.bbtgroup.model.User;
import com.ara.bbtgroup.repository.EmployeeRepository;
import com.ara.bbtgroup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(ResourceConstants.EMPLOYEE_V1)
public class EmployeeResource {

    @Autowired
    private EmployeeRepository employeeRepository;

    // ======================================
    // =             GET METHOD             =
    // ======================================

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<Employee> getAllEmployee() {

        return (List<Employee>) employeeRepository.findAll();
    }

    @GetMapping(path = "/{firstname}")
    public ResponseEntity<Employee> getEmployeeByFirstname(@PathVariable String firstname) {

        return new ResponseEntity<>(employeeRepository.findByFirstname(firstname), HttpStatus.OK);
    }

    // ======================================
    // =             POST METHOD            =
    // ======================================

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){

            return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }
}
