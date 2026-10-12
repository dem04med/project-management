package com.example.projectmanagement.model;
import jakarta.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)  //Na base de dados são armazenadas strings em vez de numeros
    @Column(nullable = false, length = 20)
    private ProjectStatus status;

    //CONSTRUCTORS
    public Project(){}

    public Project(String name, String description, ProjectStatus status){
        this.name = name;
        this.description = description;
        this.status = status;
    }

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
