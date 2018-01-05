package com.ara.bbtgroup.repository;


import com.ara.bbtgroup.model.Customer;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception{
        Customer customer1 = new Customer("Testuser 11", "Test", "Teststrasse 12", "Gossau",
                9200, "Switzerland", "test@test.ch", "071 3850000",
                "12.12.1990", false, "");
        // save user; check if ID value existing after save
        assertNull(customer1.getCustomerId());
        this.customerRepository.save(customer1);

        assertNotNull(customer1.getCustomerId());
    }

    @Test
    public void testFetchData(){
        Customer customerA = customerRepository.findByFirstname("Testuser 11");
        assertNotNull(customerA);
    }
}
