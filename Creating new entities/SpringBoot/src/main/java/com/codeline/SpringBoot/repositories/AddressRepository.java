package com.codeline.SpringBoot.repositories;

import com.codeline.SpringBoot.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query("SELECT a FROM Address a WHERE a.student.id = :studentId AND a.isActive = true")
    Address getAddressByStudentId(Integer studentId);
}


