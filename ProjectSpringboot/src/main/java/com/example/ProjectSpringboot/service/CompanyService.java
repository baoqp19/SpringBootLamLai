package com.example.ProjectSpringboot.service;

import org.springframework.stereotype.Service;

import com.example.ProjectSpringboot.domain.Company;
import com.example.ProjectSpringboot.repository.CompanyRepository;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company handleCreateCompany(Company c) {
        return this.companyRepository.save(c);
    }   
}
