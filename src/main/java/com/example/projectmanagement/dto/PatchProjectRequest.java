package com.example.projectmanagement.dto;

import com.example.projectmanagement.model.ProjectStatus;

public class PatchProjectRequest {
    private String name;
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
