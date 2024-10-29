package com.example.ProjectSpringboot.service;


import com.example.ProjectSpringboot.domain.User;
import com.example.ProjectSpringboot.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository UserRepository;
    public UserService(UserRepository userRepository){
        this.UserRepository = userRepository;
    }
    public User handleCreateUser(User user){
        return this.UserRepository.save(user);
    }
}
