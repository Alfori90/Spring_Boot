package com.codeline.SpringBoot.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String gender;

    private Date createdDate;
    private Date UpdatedDate;
    private Boolean isActive;

    @OneToMany(mappedBy = "student")
    private List<PhoneNumber> phoneNumbers;

    @OneToOne(mappedBy = "student")
    private Address address;
}
