package com.example.ProjectSpringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectSpringboot.util.error.IdInvalidException;



@RestController
public class HelloController {
    @GetMapping("/")
    public String helloWorld() throws IdInvalidException {
        return "Hello, Spring Boot!";
    }
}


