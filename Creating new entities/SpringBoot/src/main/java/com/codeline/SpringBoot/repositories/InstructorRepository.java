package com.codeline.SpringBoot.repositories;

import com.codeline.SpringBoot.Entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    @Query("SELECT i FROM Instructor i WHERE i.id=:id and i.isActive=true")
    Instructor getInstructorById(Integer id);

    @Query("SELECT COUNT(i) FROM Instructor i WHERE i.isActive=true")
    Integer getCountOfAllInstructor();

}
