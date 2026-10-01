package com.example.projectmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice //indica que esta classe fica responsável por tratar as exceções lançadas em alternativa a esta função ser desempenhada por cada um dos controllers.
public class GlobalExceptionHandler {

    @ExceptionHandler(ProjectNotFoundException.class) //indica que o seguinte metodo trata exceçoes do tipo ProjectNotFoundException
    public ResponseEntity<Map<String, String>> handleProjectNotFound(ProjectNotFoundException exception){
        Map<String, String> error = Map.of("message", exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }
}
