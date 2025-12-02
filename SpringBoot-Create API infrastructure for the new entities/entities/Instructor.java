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
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date createDate;
    private Date updetedDate;
    private Boolean isActive;
    private  String grade;
    private  String subject;

    @OneToOne
            @JoinColumn(name = "course")
    Course course;
    @ManyToOne(cascade = CascadeType.ALL)
    Department department;
}
