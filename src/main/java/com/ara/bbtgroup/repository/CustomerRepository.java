package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByFirstname(String firstname);
    Customer findByCustomerId(Integer customerId);

    @Query(value = "SELECT * FROM dbo.customer ORDER BY country", nativeQuery = true)
    List<Customer> getAllSortByCountry();

    @Query(value = "SELECT * FROM dbo.customer WHERE country = ?1", nativeQuery = true)
    List<Customer> findCustomerByCountry(String country);


}
