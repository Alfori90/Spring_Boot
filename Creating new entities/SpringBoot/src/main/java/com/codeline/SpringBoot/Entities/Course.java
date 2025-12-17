package com.codeline.SpringBoot.Entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import com.codeline.SpringBoot.Entities.Instructor;
import com.codeline.SpringBoot.Entities.Mark;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int creditHours;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private Instructor instructor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Mark> marks = new ArrayList<>();

    private Date createdDate;
    private Date updatedDate;
    private Boolean isActive;
}
