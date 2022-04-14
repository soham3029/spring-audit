package com.example.springauditing.dao;

import com.example.springauditing.dto.EmployeeReportDto;
import com.example.springauditing.dto.ProjectDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ReportDAO {

    @Autowired
    EntityManager em;

    public List<EmployeeReportDto> fetchEmployeeDetails() {
        String query = "select new com.example.springauditing.dto.EmployeeReportDto(e.empName, e.doj, e.postedLocation, e.salary) from Employee e";
        Query q = em.createQuery(query);
        return q.getResultList();
    }

    public List<ProjectDetailsDTO> fetchProjects() {
        String query = "select new com.example.springauditing.dto.ProjectDetailsDTO(p.projectName, p.projectManager, p.projStartTime) from Project p";
        Query q = em.createQuery(query);
        return q.getResultList();
    }
}
