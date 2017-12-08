package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.repository.EmployeeRepository;
import com.ara.bbtgroup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ResourceConstants.EMPLOYEE_V1)
public class EmployeeResource {

    @Autowired
    private EmployeeRepository employeeRepository;
}
