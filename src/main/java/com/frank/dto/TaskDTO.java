package com.frank.dto;

import com.frank.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class TaskDTO {

    private Long id;
    private ProjectDTO project;
    private UserDTO assignEmployee;
    private String taskSubject;
    private String taskDetail;
    private Status taskStatus;
    private LocalDate assignDate;

    public TaskDTO(ProjectDTO project, UserDTO assignEmployee, String taskSubject, String taskDetail, Status taskStatus, LocalDate assignDate) {
        this.project = project;
        this.assignEmployee = assignEmployee;
        this.taskSubject = taskSubject;
        this.taskDetail = taskDetail;
        this.taskStatus = taskStatus;
        this.assignDate = assignDate;
        this.id = UUID.randomUUID().getMostSignificantBits();
    }
}
