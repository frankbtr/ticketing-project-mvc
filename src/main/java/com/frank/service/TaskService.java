package com.frank.service;

import com.frank.dto.ProjectDTO;
import com.frank.dto.TaskDTO;
import com.frank.dto.UserDTO;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long>{
    List<TaskDTO> findTaskByManager(UserDTO manager);
}
