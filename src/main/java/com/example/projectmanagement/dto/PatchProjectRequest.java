package com.example.projectmanagement.dto;

import com.example.projectmanagement.model.ProjectStatus;
import jakarta.validation.constraints.Size;

public class PatchProjectRequest {
    @Size(max = 100, message = "O nome não pode exceder os 100 caracteres")
    private String name;
    @Size(max = 1000, message = "A descrição não pode exceder os 1000 caracteres")
    private String description;
    private ProjectStatus status;

    //CONSTRUCTOR
    public PatchProjectRequest(){}

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
    public void setStatus(ProjectStatus status){
        this.status = status;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
