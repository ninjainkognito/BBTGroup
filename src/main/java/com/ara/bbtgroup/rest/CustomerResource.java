package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.model.Customer;
import com.ara.bbtgroup.model.User;
import com.ara.bbtgroup.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerResource {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Autowired
    private CustomerRepository customerRepository;


    // ======================================
    // =             GET METHOD             =
    // ======================================

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<Customer> getAllCustomers() {

        return (List<Customer>) customerRepository.findAll();
    }

    @GetMapping(path = "/{firstname}")
    public ResponseEntity<Customer> getUserByUsername(@PathVariable String firstname) {
        return new ResponseEntity<>(customerRepository.findByFirstname(firstname), HttpStatus.OK);
    }

    @GetMapping(path = "/countries")
    public @ResponseBody List<Customer> getAllCountries(){
        return customerRepository.getAllSortByCountry();
    }

    @GetMapping(path = "/country/{country}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<Customer> getAllDTodoTaskByUserId(@PathVariable String country) {

        return customerRepository.findCustomerByCountry(country);
    }

    // ======================================
    // =             POST METHOD            =
    // ======================================

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customerRequest){

        if(customerRequest == null || customerRequest.getFirstname() == ""){
            return new ResponseEntity<Customer>(customerRequest, HttpStatus.CREATED);
        }
        else{
            customerRepository.save(customerRequest);
            return new ResponseEntity<Customer>(customerRequest, HttpStatus.CREATED);
        }
    }

    // ======================================
    // =             PUT METHOD             =
    // ======================================

    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customerRequest) {
        customerRepository.save(customerRequest);
        return new ResponseEntity<>(customerRequest, HttpStatus.OK);
    }

    // ======================================
    // =          DELETE METHOD             =
    // ======================================

    @RequestMapping(path = "/{customerId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {

        customerRepository.delete(customerId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
