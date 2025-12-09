package com.codeline.SpringBoot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private String name;
    private String description;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActive;

    @OneToMany
    List<Course> courses;

    @OneToMany
    private Instructor instructor;
}
