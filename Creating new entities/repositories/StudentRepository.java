package com.codeline.SpringBoot.repositories;

import com.codeline.SpringBoot.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(" SELECT s FROM Student s WHERE s.id=:id and s.isActive=true")
    Student getStudentById(Integer id);

    @Query("SELECT COUNT(s) FROM Student s WHERE s.isActive=true")
    Integer getCountOfAllStudent();

}
