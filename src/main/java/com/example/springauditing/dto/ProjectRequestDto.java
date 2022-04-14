package com.example.springauditing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequestDto {
    private String projName;
    private Date startTime;
    private String projectLead;
}
