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
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date createDate;
    private Date updetedDate;
    private Boolean isActive;
    private String name;
    private String email;
    private String specialization;


    @OneToOne
    Course course;
    @ManyToOne(cascade = CascadeType.ALL)
    Department department;

}
