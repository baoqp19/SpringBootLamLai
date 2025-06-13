package com.example.ProjectSpringboot.domain.respone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    private long id;
    private String email;
    private String name;
    private RoleDTO role;
}