package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.Customer;
import com.ara.bbtgroup.rest.CustomerResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @InjectMocks
    private CustomerResource customerResource;

    @Mock
    private CustomerRepository customerRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCustomerGet(){
        Customer customer = new Customer("Testuser 11", "Test", "Teststrasse 12", "Gossau",
                9200, "Switzerland", "test@test.ch", "071 3850000",
                "12.12.1990", false, "");
        customer.setCustomerId(1L);
        when(customerRepository.findOne(1L)).thenReturn(customer);

    }
}
