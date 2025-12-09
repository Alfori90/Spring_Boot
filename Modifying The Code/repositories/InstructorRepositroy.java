package com.codeline.SpringBoot.repositories;

import com.codeline.SpringBoot.RequestObject.InstructorCreateRequest;
import com.codeline.SpringBoot.RequestObject.MarkCreateRequest;
import com.codeline.SpringBoot.entities.Course;
import com.codeline.SpringBoot.entities.Instructor;
import com.codeline.SpringBoot.entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepositroy extends JpaRepository<Instructor, Integer> {
    @Query(" SELECT i FROM Instructor i WHERE i.id=:id and i.isActive=true")
    Instructor getInstructorById(Integer id);

    @Query("SELECT COUNT(i) FROM Instructor i WHERE i.isActive=true")
    Integer getCountOfAllInstructor();
}
