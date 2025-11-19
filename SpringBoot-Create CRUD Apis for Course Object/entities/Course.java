package com.codeline.SpringBoot.entities;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Course {
    private int id;
    private String name;
    private int creditHours;
    private String instructorName;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActive;
}
