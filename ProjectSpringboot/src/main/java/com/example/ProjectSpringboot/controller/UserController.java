package com.example.ProjectSpringboot.controller;


import com.example.ProjectSpringboot.domain.User;
import com.example.ProjectSpringboot.service.UserService;
import com.example.ProjectSpringboot.util.error.IdInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    public UserController(UserService userService, PasswordEncoder passwordEncoder){
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@RequestBody User postManUser){
        String hasdPassword = this.passwordEncoder.encode(postManUser.getPassword()); // thuật toán để chuyển password
        // sang mã hoá
        postManUser.setPassword(hasdPassword); // ghi để mật khẩu để lưu vào database
       User newUser =  this.userService.handleCreateUser(postManUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) throws
            IdInvalidException {
        if(id >= 1500){
            throw new IdInvalidException("id khong lon hon 1500");
        }
        this.userService.handleDeleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("Xoá thành công");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id){
        User fetchUser = this.userService.fetchUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(fetchUser);
    }
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.fetchAllUser());
    }
    @PutMapping("user")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User putUser = this.userService.handleUpdateUser(user);
        return ResponseEntity.ok(putUser);
    }


}


