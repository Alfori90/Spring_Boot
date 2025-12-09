package com.codeline.SpringBoot.repositories;

import com.codeline.SpringBoot.RequestObject.MarkCreateRequest;
import com.codeline.SpringBoot.entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {
    @Query("SELECT m FROM Mark m WHERE m.isActive=true AND m.mark IN (:marks) ")
    List<Mark> getMarkByStudentName(List<MarkCreateRequest> marks);
}
