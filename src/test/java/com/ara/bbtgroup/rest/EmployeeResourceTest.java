package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.model.Employee;
import com.ara.bbtgroup.repository.EmployeeRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeResourceTest {

    @Autowired
    private EmployeeRepository empRepo;



}
