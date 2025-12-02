package com.codeline.SpringBoot.repositories;

import com.codeline.SpringBoot.entities.Instructor;
import com.codeline.SpringBoot.entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {
}
