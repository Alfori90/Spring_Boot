package com.codeline.SpringBoot.repositories;

import com.codeline.SpringBoot.entities.Course;
import com.codeline.SpringBoot.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query(" SELECT c FROM Course c WHERE c.id=:id and c.isActive=true")
    Course getCourseById(Integer id);

    @Query("SELECT COUNT(c) FROM Course c WHERE c.isActive=true")
    Integer getCountOfAllCourse();
}
