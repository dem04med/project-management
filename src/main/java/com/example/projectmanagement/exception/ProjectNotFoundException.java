package com.example.projectmanagement.exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(Long id) {
        super("Projeto não encontrado com o ID: " + id);
    }
}
