package com.example.projectmanagement.controller;

import com.example.projectmanagement.dto.CreateProjectRequest;
import com.example.projectmanagement.dto.PatchProjectRequest;
import com.example.projectmanagement.dto.UpdateProjectRequest;
import com.example.projectmanagement.model.Project;
import com.example.projectmanagement.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    public Project createProject(@Valid @RequestBody CreateProjectRequest request){
        return projectService.createProject(request);
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
    public Project patchProject(@PathVariable Long id, @RequestBody PatchProjectRequest request){
        return projectService.patchProject(id, request);
    }
}
