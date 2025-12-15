package com.codeline.SpringBoot.Services;


import com.codeline.SpringBoot.Entities.PhoneNumber;
import com.codeline.SpringBoot.Entities.Student;
import com.codeline.SpringBoot.RequestObject.PhoneNumberCreateRequest;
import com.codeline.SpringBoot.repositories.PhoneNumberRepository;
import com.codeline.SpringBoot.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PhoneNumberService {

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Autowired
    StudentRepository studentRepository;


    public PhoneNumber addPhoneNumberToStudent(Integer studentId, PhoneNumberCreateRequest requestObj) throws Exception {

        Student student = studentRepository.getStudentById(studentId);
        if (student == null) {
            throw new Exception("Student not found with ID = " + studentId);
        }
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber(requestObj.getNumber());
        phoneNumber.setCountryCode(requestObj.getCountryCode());
        phoneNumber.setIsLandLine(requestObj.getIsLandLine());
        phoneNumber.setCreatedDate(new Date());
        phoneNumber.setIsActive(Boolean.TRUE);

        phoneNumber.setStudent(student);
        return phoneNumberRepository.save(phoneNumber);
    }


    public PhoneNumber updatePhoneNumber(PhoneNumber number) throws Exception {
        PhoneNumber existingPhoneNumber = phoneNumberRepository.findById(number.getId()).get();
        if (existingPhoneNumber != null && existingPhoneNumber.getIsActive()) {
            number.setUpdatedDate(new Date());
            return phoneNumberRepository.save(number);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public void deletePhoneNumber(Integer id) throws Exception {
        PhoneNumber existingPhoneNumber = phoneNumberRepository.findById(id).get();
        if (existingPhoneNumber != null && existingPhoneNumber.getIsActive()) {
            existingPhoneNumber.setUpdatedDate(new Date());
            existingPhoneNumber.setIsActive(Boolean.FALSE);
            phoneNumberRepository.save(existingPhoneNumber);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
}
