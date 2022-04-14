package com.example.springauditing.controller;

import com.example.springauditing.request.CreateEmployeeRequest;
import com.example.springauditing.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class EmployeeController {

    @Autowired
    private IEmployeeService service;
    @PostMapping(value = "/saveEmployee")
    public void createEmployee(@RequestBody CreateEmployeeRequest request)
    {
        log.info("Saving employee...");
        service.createEmployee(request);
        log.info("Employee saved successfully");
    }
}
