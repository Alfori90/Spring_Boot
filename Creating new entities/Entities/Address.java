package com.codeline.SpringBoot.Entities;


import jakarta.persistence.*;
import com.codeline.SpringBoot.Entities.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String houseNumber;
    private String street;
    private String city;
    private String stateOrProvince;
    private String country;
    private String  postalCode;

    private Date createdDate;
    private Date UpdatedDate;
    private Boolean isActive;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
