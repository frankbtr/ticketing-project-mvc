package com.frank.service;

import com.frank.dto.ProjectDTO;
import com.frank.service.CrudService;

public interface ProjectService extends CrudService<ProjectDTO, String> {
    void complete(ProjectDTO project);
}
