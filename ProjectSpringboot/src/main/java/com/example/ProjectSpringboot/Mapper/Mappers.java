package com.example.ProjectSpringboot.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.ProjectSpringboot.domain.Role;
import com.example.ProjectSpringboot.domain.User;
import com.example.ProjectSpringboot.domain.respone.PermissionDTO;
import com.example.ProjectSpringboot.domain.respone.RoleDTO;
import com.example.ProjectSpringboot.domain.respone.UserLoginDTO;

public class Mappers {
    public RoleDTO mapToRoleDTO(Role role) {
        List<PermissionDTO> permissionDTOs = role.getPermissions().stream()
                .map(p -> new PermissionDTO(p.getId(), p.getName(), p.getApiPath(), p.getMethod(), p.getModule()))
                .collect(Collectors.toList());

        return new RoleDTO(role.getId(), role.getName(), role.getDescription(), role.isActive(), permissionDTOs);
    }

    public UserLoginDTO mapToUserLoginDTO(User user) {
        return new UserLoginDTO(
                user.getId(),
                user.getEmail(),
                user.getName(),
                mapToRoleDTO(user.getRole()));
    }
}
