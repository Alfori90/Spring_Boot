package com.codeline.SpringBoot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Data
@Builder
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int creditHours;
    private String instructorName;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActive;
}
