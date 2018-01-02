package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    Employee findByFirstname(String firstname);
    Employee findByEmployeeId(Long id);

    @Query(value = "SELECT * FROM dbo.employee WHERE country = ?1", nativeQuery = true)
    List<Employee> findEmployeeByCountry(String country);
}
