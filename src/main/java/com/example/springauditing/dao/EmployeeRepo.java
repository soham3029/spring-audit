package com.example.springauditing.dao;

import com.example.springauditing.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends RevisionRepository<Employee, Integer, Integer> , JpaRepository<Employee, Integer> {
}
