package com.codeline.SpringBoot.repositories;

import com.codeline.SpringBoot.entities.Department;
import com.codeline.SpringBoot.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("SELECT dept FROM Department dept WHERE dept.id=:deptId AND dept.isActive=true")
    Department getDepartmentById(Integer deptId);

    @Query("SELECT dept FROM Department dept WHERE dept.isActive=true")
    List<Department> getAllActiveDepartments();
}
