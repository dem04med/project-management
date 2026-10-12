package com.example.projectmanagement.service;

import com.example.projectmanagement.dto.CreateProjectRequest;
import com.example.projectmanagement.dto.PatchProjectRequest;
import com.example.projectmanagement.dto.UpdateProjectRequest;
import com.example.projectmanagement.exception.ProjectNotFoundException;
import com.example.projectmanagement.model.Project;
import com.example.projectmanagement.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public Project createProject(CreateProjectRequest request){
        Project project = new Project(
                request.getName(),
                request.getDescription(),
                request.getStatus()
        );

        return projectRepository.save(project);
    }

    public Project getProjectById(Long id){
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

    public Project updateProject(Long id, UpdateProjectRequest request){
        Project project = getProjectById(id);

        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setStatus(request.getStatus());

        return projectRepository.save(project);
    }

    public Project patchProject(Long id, PatchProjectRequest request){
        Project project = getProjectById(id);

        if(request.getName() != null){
            if(request.getName().isBlank()){
                throw new IllegalArgumentException("O nome não pode estar vazio!");
            }

            project.setName(request.getName());
        }

        if(request.getDescription() != null){
            if(request.getDescription().isBlank()){
                throw new IllegalArgumentException("A descrição não pode estar vazia!");
            }

            project.setDescription(request.getDescription());
        }

        if(request.getStatus() != null){
            project.setStatus(request.getStatus());
        }

        return projectRepository.save(project);
    }

    public void deleteProject(Long id){
        Project project = getProjectById(id);
        projectRepository.delete(project);
    }
}
