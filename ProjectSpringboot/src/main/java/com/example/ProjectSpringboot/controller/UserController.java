package com.example.ProjectSpringboot.controller;


import com.example.ProjectSpringboot.domain.User;
import com.example.ProjectSpringboot.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService ){
        this.userService = userService;
    }

    @PostMapping("/user/create")
    public User createUser(@RequestBody User postUser){

       User newUser =  this.userService.handleCreateUser(postUser);

       return newUser;
    }
}


