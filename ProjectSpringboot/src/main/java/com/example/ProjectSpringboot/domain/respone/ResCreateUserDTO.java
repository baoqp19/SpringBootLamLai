package com.example.ProjectSpringboot.domain.respone;

import java.time.Instant;

import com.example.ProjectSpringboot.util.constant.GenderEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResCreateUserDTO {
    private long id;
    private String name;
    private String email;
    private GenderEnum gender;
    private String address;
    private int age;
    private Instant createdAt;

    private CompanyUser company;
    
    @Getter
    @Setter
    public static class CompanyUser {
        private long id;
        private String name;
    }
}
