package com.codeline.SpringBoot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne(mappedBy = "course",cascade = CascadeType.ALL)
    Instructor instructor;
}
