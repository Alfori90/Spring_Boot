package com.codeline.SpringBoot.repositories;

import com.codeline.SpringBoot.entities.Department;
import com.codeline.SpringBoot.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
