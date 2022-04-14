package com.example.springauditing.request;

import com.example.springauditing.dto.ProjectRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    private String empName;
    private Date doj;
    private String ssnNo;
    private BigDecimal salary;
    private String parmanentAddress;
    private String postedLocation;
    private List<ProjectRequestDto> projectRequestDtos;
}
