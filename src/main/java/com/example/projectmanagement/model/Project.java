package com.example.projectmanagement.model;

public class Project {
    private Long id;
    private String name;
    private String description;
    private ProjectStatus status;

    //CONSTRUCTORS
    public Project(Long id, String name, String description, ProjectStatus status){
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    //GETTERS
    public Long getId(){
        return id;
    }

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
        this. name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setStatus(ProjectStatus status){
        this.status = status;
    }
}
