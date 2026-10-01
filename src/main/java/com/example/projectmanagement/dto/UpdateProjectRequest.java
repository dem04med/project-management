package com.example.projectmanagement.dto;

import com.example.projectmanagement.model.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateProjectRequest {
    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "A descrição é obrigatória")
    private String description;

    @NotNull(message = "O status é obrigatório")
    private ProjectStatus status;

    //CONSTRUCTOR
    public UpdateProjectRequest(){}

    //GETTERS
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public ProjectStatus getStatus(){
        return status;
    }

    //SETTERS
    public void setName(String name){
        this.name = name;
    }

    public void setStatus(ProjectStatus status){
        this.status = status;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
