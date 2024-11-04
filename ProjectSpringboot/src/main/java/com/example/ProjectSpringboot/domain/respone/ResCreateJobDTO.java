package com.example.ProjectSpringboot.domain.respone;

import java.time.Instant;
import java.util.List;

import org.h2.value.Transfer;

import com.example.ProjectSpringboot.util.constant.LevelEnum;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResCreateJobDTO {
    // DTO là viết tắt của Data Transfer Object,

    private long id;
    
    private String name;
    
    private String location;
    
    private double salary;
    
    private int quantity;
    
    private LevelEnum level;
    
    private Instant startDate;
    
    private Instant endDate;
    
    private boolean isActive;
    
    private List<String> skills;
    
    private Instant createdAt;
    
    private String createdBy;


    
}
