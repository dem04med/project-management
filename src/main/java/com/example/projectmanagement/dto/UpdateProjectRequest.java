package com.example.projectmanagement.dto;

import com.example.projectmanagement.model.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateProjectRequest {
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome não pode exceder os 100 caracteres")
    private String name;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 1000, message = "A descrição não pode exceder os 1000 caracteres")
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
