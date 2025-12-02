package com.codeline.SpringBoot.repositories;

import com.codeline.SpringBoot.entities.Course;
import com.codeline.SpringBoot.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepositroy extends JpaRepository<Instructor, Integer> {
}
