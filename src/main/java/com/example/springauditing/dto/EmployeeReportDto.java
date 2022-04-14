package com.example.springauditing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeReportDto {
    private String employeeName;
    private Date doj;
    private String postedLocation;
    private BigDecimal salary;
    private List<ProjectDetailsDTO> projectDetailsDTOS;

    public EmployeeReportDto(String employeeName, Date doj, String postedLocation, BigDecimal salary) {
        this.employeeName = employeeName;
        this.doj = doj;
        this.postedLocation = postedLocation;
        this.salary = salary;
    }
}
