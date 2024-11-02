package com.example.ProjectSpringboot.service;

import com.example.ProjectSpringboot.domain.User;
import com.example.ProjectSpringboot.domain.respone.Meta;
import com.example.ProjectSpringboot.domain.respone.ResultPaginationDTO;
import com.example.ProjectSpringboot.repository.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public User fetchUserById(long id) {
        // optional là có hay không
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) { // isPresent() có hay không
            return userOptional.get();
        }
        return null;
    }

     public ResultPaginationDTO fetchAllUser(Specification<User> spec, Pageable pageable) {
        Page<User> pageUser = this.userRepository.findAll(spec, pageable);

        ResultPaginationDTO rs = new ResultPaginationDTO();
        Meta mt = new Meta();
        
        mt.setPage(pageable.getPageNumber() + 1);
        mt.setPageSize(pageable.getPageSize());
        
        mt.setPages(pageUser.getTotalPages());
        mt.setTotal(pageUser.getTotalElements());
        
        
        rs.setMeta(mt);
        rs.setResult(pageUser.getContent());
        return rs;
    }

    /**
     * gạch chân giá trị có thể null nếu cập nhập mà giá trị không thay đôi
     */
    public User handleUpdateUser(User reqUser) {
        User currentUser = this.fetchUserById(reqUser.getId());
        if (currentUser != null) {
            currentUser.setEmail(reqUser.getEmail());
            currentUser.setName(reqUser.getName());
            currentUser.setPassword(reqUser.getPassword());
            currentUser = this.userRepository.save(currentUser);
        }
        return currentUser;
    }

    public User handleGetUserByUsername(String username) {
        return this.userRepository.findByEmail(username);
    }

}
