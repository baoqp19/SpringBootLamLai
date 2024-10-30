package com.example.ProjectSpringboot.service;


import com.example.ProjectSpringboot.domain.User;
import com.example.ProjectSpringboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User handleCreateUser(User user){
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(long id){
        this.userRepository.deleteById(id);
    }

    public User fetchUserById(long id){
        // optional là có hay không
        Optional<User> userOptional = this.userRepository.findById(id);
        if(userOptional.isPresent()){  // isPresent() có hay không
            return userOptional.get();
        }
        return null;
    }

    public List<User> fetchAllUser(){
        return this.userRepository.findAll();
    }

    /**
     * gạch chân giá trị có thể null nếu cập nhập mà giá trị không thay đôi
     */
    public User handleUpdateUser(User reqUser){
        User currentUser = this.fetchUserById(reqUser.getId());
        if(currentUser != null){
            currentUser.setEmail(reqUser.getEmail());
            currentUser.setName(reqUser.getName());
            currentUser.setPassword(reqUser.getPassword());
            currentUser = this.userRepository.save(currentUser);
        }
        return currentUser;
    }
}
