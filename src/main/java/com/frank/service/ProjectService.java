package com.frank.service;

import com.frank.dto.ProjectDTO;
import com.frank.dto.UserDTO;
import com.frank.service.CrudService;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDTO, String> {
    void complete(ProjectDTO project);

    List<ProjectDTO> findAllNonCompletedProjects();

    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);
}
