package com.example.ProjectSpringboot.domain.respone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDTO {
    private long id;
    private String name;
    private String apiPath;
    private String method;
    private String module;
}