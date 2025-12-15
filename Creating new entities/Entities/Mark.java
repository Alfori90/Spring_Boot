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
@NoArgsConstructor
@AllArgsConstructor
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double score;

    private Date createdDate;
    private Date UpdatedDate;
    private Boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;

}
