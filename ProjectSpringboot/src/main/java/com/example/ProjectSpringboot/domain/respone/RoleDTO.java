package com.example.ProjectSpringboot.domain.respone;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private long id;
    private String name;
    private String description;
    private boolean active;
    private List<PermissionDTO> permissions;
}