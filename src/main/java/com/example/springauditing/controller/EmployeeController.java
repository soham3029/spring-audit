package com.example.springauditing.controller;

import com.example.springauditing.request.CreateEmployeeRequest;
import com.example.springauditing.service.IEmployeeService;
import com.example.springauditing.util.ReportService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@CrossOrigin
@Slf4j
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

    @Autowired
    private ReportService reportService;

    @PostMapping(value = "/saveEmployee")
    public void createEmployee(@RequestBody CreateEmployeeRequest request)
    {
        log.info("Saving employee...");
        service.createEmployee(request);
        log.info("Employee saved successfully");
    }

    @GetMapping()
    public void exportFile(@RequestParam("format") String format) throws JRException, FileNotFoundException {
        reportService.exportReport(format);
    }
}
