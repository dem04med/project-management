package com.example.projectmanagement.service;

import com.example.projectmanagement.dto.CreateProjectRequest;
import com.example.projectmanagement.dto.PatchProjectRequest;
import com.example.projectmanagement.dto.UpdateProjectRequest;
import com.example.projectmanagement.exception.ProjectNotFoundException;
import com.example.projectmanagement.model.Project;
import com.example.projectmanagement.model.ProjectStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    private final List<Project> projects = new ArrayList<>();
    private long nextId = 1; //O nextId representa o novo id a ser atribuído a um projeto

    public List<Project> getAllProjects(){
        return List.copyOf(projects);
    }

    public Project createProject(CreateProjectRequest request){
        long id = nextId++;

        Project project = new Project(
                id,
                request.getName(),
                request.getDescription(),
                request.getStatus()
        );

        projects.add(project);

        return project;
    }

    public Project getProjectById(Long id){
        return projects.stream()
                .filter(project -> project.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

    public Project updateProject(Long id, UpdateProjectRequest request){
        Project project = getProjectById(id);

        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setStatus(request.getStatus());

        return project;
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

        return project;
    }
}
