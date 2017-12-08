package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    Employee findByFirstname(String firstname);
}
