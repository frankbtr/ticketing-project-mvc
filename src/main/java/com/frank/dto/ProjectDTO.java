package com.frank.dto;

import com.frank.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.util.pattern.PathPattern;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectDTO {

    private String projectName;
    private String projectCode;
    private UserDTO assignManager;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String projectDetail;
    private Status projectStatus;

    public ProjectDTO(String projectName, String projectCode, UserDTO assignManager, LocalDate startDate, LocalDate endDate, String projectDetail, Status projectStatus) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.assignManager = assignManager;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectDetail = projectDetail;
        this.projectStatus = projectStatus;
    }

    private int completeTaskCounts;
    private int unfinishedTaskCounts;
}
