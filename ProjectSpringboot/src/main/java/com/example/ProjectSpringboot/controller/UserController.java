package com.example.ProjectSpringboot.controller;


import com.example.ProjectSpringboot.domain.User;
import com.example.ProjectSpringboot.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService ){
        this.userService = userService;
    }

    @GetMapping("/user/create")
    public String createUser(){
        User user = new User();
        user.setEmail("phamquocbao@gmail.com");
        user.setName("quocbao");
        user.setPassword("123456");

        this.userService.handleCreateUser(user);
        return "create user";
    }
}
