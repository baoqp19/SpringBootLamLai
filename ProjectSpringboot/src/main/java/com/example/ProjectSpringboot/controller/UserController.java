package com.example.ProjectSpringboot.controller;


import com.example.ProjectSpringboot.domain.User;
import com.example.ProjectSpringboot.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") long id){
        this.userService.handleDeleteUser(id);
        return "bao";
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") long id){
        return this.userService.fetchUserById(id);
    }
    @GetMapping("/user")
    public List<User> getAllUser(){
        return this.userService.fetchAllUser();
    }
    @PutMapping("user")
    public User updateUser(@RequestBody User user){
        User putUser = this.userService.handleUpdateUser(user);
        return putUser;
    }


}


