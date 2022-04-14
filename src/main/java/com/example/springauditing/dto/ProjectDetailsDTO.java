package com.example.springauditing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDetailsDTO {
    private String projName;
    private String projectLead;
    private Date projectStartTime;
}
