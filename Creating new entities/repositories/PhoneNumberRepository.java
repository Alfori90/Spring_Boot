package com.codeline.SpringBoot.repositories;

import com.codeline.SpringBoot.Entities.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Integer> {
    @Query("SELECT p FROM PhoneNumber p WHERE p.isActive = true AND p.student.id = :studentId")
    List<PhoneNumber> getPhoneNumberByStudentId(Integer studentId);
}
