package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    Employee findByEmployeeId(Integer employeeId);
}
