package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.model.Employee;
import com.ara.bbtgroup.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeResourceTest {

    @Autowired
    private EmployeeRepository empRepo;

    @Test
    public void saveEmployee_whenFoundById_thenOk(){

        Employee emplyoee = empRepo
                .save(new Employee("Max", "Muster", "Musterstrasse 50",
                        "city", 1234, "country", "Administrator",
                        "test@test.ch", "078 0000000", "1990-01-01",0));

        Employee foundEmployee = empRepo.findOne(emplyoee.getEmployeeId());

        assertNotNull(foundEmployee);
        assertEquals(emplyoee.getEmployeeId(), foundEmployee.getEmployeeId());
    }

    @Test
    public void saveMultipleEmployee_AndFindAll_whenMultipleFound_thenOk(){

        Employee employee = new Employee("Max", "Muster", "Musterstrasse 50",
                "city", 1234, "country", "Administrator",
                "test@test.ch", "078 0000000", "1990-01-01",0);


        this.empRepo.save(employee);

        List<Employee> employeeList = (List<Employee>) empRepo.findAll();

        assertNotNull(employeeList);
        assertTrue(employeeList.size() > 0);
    }

    public void saveEmployeeAndDelete_whenDeleted_thenOk(){

        Employee employee = empRepo
                .save(new Employee("Max", "Muster", "Musterstrasse 50",
                        "city", 1234, "country", "Administrator",
                        "test@test.ch", "078 0000000", "1990-01-01",0));

        // check if data successfully written into database
        assertTrue(empRepo.findOne(employee.getEmployeeId()).getZipcode() == 1234);

        Long lastInsert = empRepo.findOne(employee.getEmployeeId()).getEmployeeId();

        empRepo.delete(lastInsert);

        assertNull(empRepo.findOne(lastInsert));
    }

    public void updateEmployee_whenUpdated_thenOk(){
        Employee employee = empRepo
                .save(new Employee("Max", "Muster", "Musterstrasse 50",
                        "city", 1234, "country", "Administrator",
                        "test@test.ch", "078 0000000", "1990-01-01",0));

        Employee foundEmployee = empRepo.findOne(employee.getEmployeeId());
        foundEmployee.setZipcode(987654321);

        empRepo.save(foundEmployee);

        assertTrue(empRepo.findOne(employee.getEmployeeId()).getZipcode() == 987654321);
    }

}
