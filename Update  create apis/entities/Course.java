package com.codeline.SpringBoot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int creditHours;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActive;

    @OneToOne(cascade = CascadeType.ALL)
    private Instructor instructor;
    
    @OneToMany
    private List<Mark> marks;

    @ManyToOne
    private Department department;
}
