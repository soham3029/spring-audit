package com.example.springauditing.util;

import com.example.springauditing.dao.ReportDAO;
import com.example.springauditing.dto.EmployeeReportDto;
import com.example.springauditing.dto.ProjectDetailsDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    private ReportDAO repo;

    public String exportReport(String format) throws FileNotFoundException, JRException {
        List<EmployeeReportDto> dto = repo.fetchEmployeeDetails();
        List<ProjectDetailsDTO> projectDetailsDTOS = repo.fetchProjects();
        EmployeeReportDto dto1 = new EmployeeReportDto();
        dto1.setProjectDetailsDTOS(projectDetailsDTOS);
        dto.add(dto1);
        File file = ResourceUtils.getFile("classpath:employee_report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dto);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Created By ", "Soham");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if(format.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\acer\\OneDrive\\Documents\\Report"+"\\employee.pdf");
        }
        else if(format.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "C:\\Users\\acer\\OneDrive\\Documents\\Report"+"\\employee.pdf");
        }
        return "Report generated";
    }
}
