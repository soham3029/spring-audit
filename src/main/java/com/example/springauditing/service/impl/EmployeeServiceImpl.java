package com.example.springauditing.service.impl;

import com.example.springauditing.dao.EmployeeRepo;
import com.example.springauditing.dao.ProjectRepository;
import com.example.springauditing.dto.ProjectRequestDto;
import com.example.springauditing.model.Employee;
import com.example.springauditing.model.Project;
import com.example.springauditing.request.CreateEmployeeRequest;
import com.example.springauditing.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public void createEmployee(CreateEmployeeRequest request) {
        Employee employee = new Employee();
        List<Employee> employees = new ArrayList<>();
        employee.setEmpName(request.getEmpName());
        employee.setSsnNo(request.getSsnNo());
        employee.setPermanentAddress(request.getParmanentAddress());
        employee.setPostedLocation(request.getPostedLocation());
        employee.setSalary(request.getSalary());
        employee.setCreated(new Date());
        employee.setUpdated(new Date());
        employee.setDoj(request.getDoj());
        employee.setCreatedBy("Admin");
        employees.add(employee);
        List<Project> projectList = setProjectDetailsOfThatEmployee(request, employees);
        employee.setProjectList(projectList);
        employeeRepo.saveAll(employees);
        log.info("Employee saved successfully");
    }

    private List<Project> setProjectDetailsOfThatEmployee(CreateEmployeeRequest request, List<Employee> employees) {
        List<Project> projects = new ArrayList<>();
        for(ProjectRequestDto dto: request.getProjectRequestDtos()){
            Project project = new Project();
            project.setProjectName(dto.getProjName());
            project.setProjStartTime(dto.getStartTime());
            project.setProjectManager(dto.getProjectLead());
            project.setEmployees(employees);
            projects.add(project);
            projects = projectRepository.saveAll(projects);
            log.info("Project saved successfully");
        }
        return projects;
    }
}
