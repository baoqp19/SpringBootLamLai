package com.example.ProjectSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.ProjectSpringboot.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>,
                    JpaSpecificationExecutor<Role> {
    boolean existsByName(String name);
}
