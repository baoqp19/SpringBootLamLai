package com.example.ProjectSpringboot.repository;

import com.example.ProjectSpringboot.domain.Company;
import com.example.ProjectSpringboot.domain.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    // tìm theo email
    User findByEmail(String email);

    // kiểm tra xem email có trong db chưa
    boolean existsByEmail(String email);

    // Cách viết đúng nhất
    User findByRefreshTokenAndEmail(String token, String email);

    // lấy ra user thuộc công ty // có thuộc tính nên lấy ra dc
    List<User> findByCompany(Company company);
}
