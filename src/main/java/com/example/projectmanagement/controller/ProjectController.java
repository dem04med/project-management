package com.example.projectmanagement.controller;

import com.example.projectmanagement.dto.CreateProjectRequest;
import com.example.projectmanagement.dto.PatchProjectRequest;
import com.example.projectmanagement.dto.UpdateProjectRequest;
import com.example.projectmanagement.model.Project;
import com.example.projectmanagement.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@Valid @RequestBody CreateProjectRequest request){
        Project createdProject = projectService.createProject(request);

        URI location = URI.create("/api/projects/" + createdProject.getId());

        return ResponseEntity
                .created(location) //apresenta a localização do projeto criado e define o HTTP Status para 201 Created
                .body(createdProject);
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id){
        return projectService.getProjectById(id);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @Valid @RequestBody UpdateProjectRequest request){
        return projectService.updateProject(id, request);
    }

    @PatchMapping("/{id}")
    public Project patchProject(@PathVariable Long id, @Valid @RequestBody PatchProjectRequest request){
        return projectService.patchProject(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
