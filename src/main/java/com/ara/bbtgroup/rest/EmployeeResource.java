package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.model.Employee;
import com.ara.bbtgroup.model.Task;
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
@RequestMapping("/employees")
public class EmployeeResource {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

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
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    // ======================================
    // =             PUT METHOD             =
    // ======================================

    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employeeRequest) {

        employeeRepository.save(employeeRequest);
        return new ResponseEntity<>(employeeRequest, HttpStatus.OK);
    }

    // ======================================
    // =          DELETE METHOD             =
    // ======================================

    @RequestMapping(path = "/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        employeeRepository.delete(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
