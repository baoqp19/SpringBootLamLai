package com.example.ProjectSpringboot.util.error;

public class PermissionException extends Exception {
    public PermissionException(String message){
        super(message);
    }
}