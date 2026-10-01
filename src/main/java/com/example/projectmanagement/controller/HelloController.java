package com.example.projectmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //torna o Controller acessível a partir da Rest API
public class HelloController {

    @GetMapping("/api/hello")  //indica o metodo a ser executado pelo endpoint definido
    public String hello(){
        return "Hello, Project Management!";
    }
}
