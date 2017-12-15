package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByFirstname(String firstname);
    Customer findByCustomerId(Integer customerId);
}
