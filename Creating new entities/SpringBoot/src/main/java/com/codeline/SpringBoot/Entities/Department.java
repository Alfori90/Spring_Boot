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
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;
    String description;
    Date createdDate;
    Date UpdatedDate;
    Boolean isActive;

}
