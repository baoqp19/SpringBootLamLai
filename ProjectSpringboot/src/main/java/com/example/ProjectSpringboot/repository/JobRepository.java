package com.example.ProjectSpringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.ProjectSpringboot.domain.Job;
import com.example.ProjectSpringboot.domain.Skill;

public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {
     List<Job> findBySkillsIn(List<Skill> skills);
}



