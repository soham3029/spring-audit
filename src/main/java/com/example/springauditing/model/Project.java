package com.example.springauditing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project", catalog = "spring_aud")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String projectName;
    private String projectManager;
    private Date projStartTime;
    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    private List<Employee> employees;
}
