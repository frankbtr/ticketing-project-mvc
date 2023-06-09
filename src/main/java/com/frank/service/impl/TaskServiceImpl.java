package com.frank.service.impl;

import com.frank.dto.ProjectDTO;
import com.frank.dto.TaskDTO;
import com.frank.dto.UserDTO;
import com.frank.enums.Status;
import com.frank.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO object) {

        if (object.getTaskStatus() == null) {
            object.setTaskStatus(Status.OPEN);
        }

        if (object.getAssignDate() == null) {
            object.setAssignDate(LocalDate.now());
        }

        if (object.getId() == null) {
            object.setId(UUID.randomUUID().getMostSignificantBits());
        }

        return super.save(object.getId(), object);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(TaskDTO object) {

        TaskDTO foundTask = findById(object.getId());

        object.setTaskStatus(foundTask.getTaskStatus());
        object.setAssignDate(foundTask.getAssignDate());

        super.update(object.getId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findTaskByManager(UserDTO manager) {
        return super.findAll().stream().filter(taskDTO -> taskDTO.getAssignEmployee().equals(manager)).collect(Collectors.toList());
    }
}
