package com.frank.service.impl;

import com.frank.dto.ProjectDTO;
import com.frank.dto.TaskDTO;
import com.frank.dto.UserDTO;
import com.frank.enums.Status;
import com.frank.service.ProjectService;
import com.frank.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {

    private final TaskService taskService;

    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ProjectDTO save(ProjectDTO object) {

        if (object.getProjectStatus() == null){
            object.setProjectStatus(Status.OPEN);
        }

        return super.save(object.getProjectCode(), object);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDTO object) {

        ProjectDTO projectDTO = findById(object.getProjectCode());
        if (object.getProjectStatus() == null){
            object.setProjectStatus(projectDTO.getProjectStatus());
        }
        super.update(object.getProjectCode(), object);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setProjectStatus(Status.COMPLETE);
        super.save(project.getProjectCode(), project);
    }

    @Override
    public List<ProjectDTO> findAllNonCompletedProjects() {
        return findAll().stream().filter(projectDTO -> !projectDTO.getProjectStatus().equals(Status.COMPLETE)).collect(Collectors.toList());
    }


    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {

        List<ProjectDTO> projectList = findAll().stream()
                .filter(projectDTO -> projectDTO.getAssignManager().equals(manager))
                .map(//one goal - build that projects - w AllArgConstructor
                        projectDTO -> {

                            List<TaskDTO> taskList = taskService.findTaskByManager(manager);

                            int completeTaskCounts = (int) taskList.stream().filter(taskDTO -> taskDTO.getProject().equals(projectDTO) && taskDTO.getTaskStatus() == Status.COMPLETE).count();
                            int unfinishedTaskCounts = (int) taskList.stream().filter(taskDTO -> taskDTO.getProject().equals(projectDTO) && taskDTO.getTaskStatus() != Status.COMPLETE).count();

                            projectDTO.setCompleteTaskCounts(completeTaskCounts);
                            projectDTO.setUnfinishedTaskCounts(unfinishedTaskCounts);
                            return projectDTO;
                        }).collect(Collectors.toList());

        return projectList;
    }
}
