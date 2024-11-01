package com.example.ProjectSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProjectSpringboot.domain.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
