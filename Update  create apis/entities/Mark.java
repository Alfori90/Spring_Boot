package com.codeline.SpringBoot.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String studentName;
    private Double score;
    private Date createDate;
    private Date updetedDate;
    private Boolean isActive;

    @OneToMany
    private Course course;

    @OneToMany
    private Instructor instructor;

}
