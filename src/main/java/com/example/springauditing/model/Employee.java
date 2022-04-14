package com.example.springauditing.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee", catalog = "spring_aud")
@Audited(
        targetAuditMode = RelationTargetAuditMode.NOT_AUDITED
)
@AuditTable(
        value = "employee_history",
        catalog = "spring_aud"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String empName;
    private String ssnNo;
    private String permanentAddress;
    private String postedLocation;
    private BigDecimal salary;
    private Date doj;
    private Date created;
    private Date updated;
    private String createdBy;
    private String updatedBy;

    @ManyToMany(targetEntity = Project.class, cascade = CascadeType.ALL)
    private List<Project> projectList;
}
