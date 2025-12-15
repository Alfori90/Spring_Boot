package com.codeline.SpringBoot.repositories;

import com.codeline.SpringBoot.Entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark,Integer> {

    @Query("SELECT m FROM Mark m WHERE m.isActive = true AND m.course.id = :courseId ")
    List<Mark> getMarkByCourseId(Integer courseId);

}
