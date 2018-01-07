package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.model.Customer;
import com.ara.bbtgroup.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerResourceTest {

    @Autowired
    private CustomerRepository custRepo;

    @Test
    public void saveCustomer_whenFoundById_thenOk(){

        Customer customer = custRepo
                .save(new Customer("Max", "Muster", "Musterstrasse 50",
                        "city", 9500, "country", "test@test.ch",
                        "078 0000000", "19900-01-01", false,""));

        Customer foundCustomer = custRepo.findOne(customer.getCustomerId());

        assertNotNull(foundCustomer);
        assertEquals(customer.getCustomerId(), foundCustomer.getCustomerId());
    }

    @Test
    public void saveMultipleCustomers_AndFindAll_whenMultipleFound_thenOk(){

        Customer customer = new Customer("Max", "Muster", "Musterstrasse 50",
                "city", 9500, "country", "test@test.ch",
                "078 0000000", "19900-01-01", false,"");
        Customer customer1 = new Customer("Tom", "Muster", "Musterstrasse 50",
                "city", 9500, "country", "test@test.ch",
                "078 0000000", "19900-01-01", false,"");
        Customer customer2 = new Customer("Ernst", "Muster", "Musterstrasse 50",
                "city", 9500, "country", "test@test.ch",
                "078 0000000", "19900-01-01", false,"");

        this.custRepo.save(customer);
        this.custRepo.save(customer1);
        this.custRepo.save(customer2);


        List<Customer> customerList = (List<Customer>) custRepo.findAll();

        assertNotNull(customerList);
        assertTrue(customerList.size() > 0);
    }

    @Test
    public void saveCustomerAndDelete_whenDeleted_thenOk(){

        Customer customer = custRepo
                .save(new Customer("Max", "Muster", "Musterstrasse 50",
                        "city", 1234, "country", "test@test.ch",
                        "078 0000000", "19900-01-01", false,""));

        // check if data successfully written into database
        assertEquals(java.util.Optional.ofNullable(custRepo.findOne(customer.getCustomerId()).getZipcode()), 1234);

        Long lastInsertJob = custRepo.findOne(customer.getCustomerId()).getCustomerId();

        custRepo.delete(lastInsertJob);

        assertNull(custRepo.findOne(lastInsertJob));

    }

    @Test
    public void updateCustomer_whenUpdated_thenOk(){
        Customer customer = custRepo
                .save(new Customer("Max", "Muster", "Musterstrasse 50",
                        "city", 1234, "country", "test@test.ch",
                        "078 0000000", "19900-01-01", false,""));

        Customer foundCustomer = custRepo.findOne(customer.getCustomerId());
        foundCustomer.setZipcode(987654321);

        custRepo.save(foundCustomer);

        assertEquals(java.util.Optional.of(987654321), custRepo.findOne(customer.getCustomerId()).getZipcode());
    }
}
