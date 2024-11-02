package com.example.ProjectSpringboot.domain;


import java.time.Instant;

import com.example.ProjectSpringboot.util.SecurityUtil;
import com.example.ProjectSpringboot.util.constant.GenderEnum;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "name không được để trống")
    private String name;

    @NotBlank(message = "email không được để trống")
    private String email;

    @NotBlank(message = "password không được để trống")
    private String password;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

     private String address;
    private int age;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String refreshToken;
    
    private Instant createdAt;
    private Instant updatedAt;
    private String createdBy;
    private String updatedBy;

    @PrePersist
    public void handleBeforeCreate() {
        this.createdBy = SecurityUtil.getCurrentUserLogin().isPresent() == true
                ? SecurityUtil.getCurrentUserLogin().get()
                : "";

        this.createdAt = Instant.now();
    }

        @PreUpdate
        public void handleBeforeUpdate() {
            this.updatedBy = SecurityUtil.getCurrentUserLogin().isPresent() == true
                    ? SecurityUtil.getCurrentUserLogin().get()
                    : "";
        this.updatedAt = Instant.now();
    }
}
