package com.codeline.SpringBoot.Services;

import com.codeline.SpringBoot.Helper.Constants;
import com.codeline.SpringBoot.Helper.HelperUtils;
import com.codeline.SpringBoot.RequestObject.InstructorCreateRequest;
import com.codeline.SpringBoot.Entities.Course;
import com.codeline.SpringBoot.Entities.Department;
import com.codeline.SpringBoot.Entities.Instructor;
import com.codeline.SpringBoot.repositories.CourseRepository;
import com.codeline.SpringBoot.repositories.DepartmentRepository;
import com.codeline.SpringBoot.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DepartmentRepository departmentRepository;


    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }


    public Instructor saveInstructor(InstructorCreateRequest request) throws Exception {
        Instructor instructor = InstructorCreateRequest.convertToInstructor(request);
        instructor.setCreatedDate(new Date());
        instructor.setIsActive(Boolean.TRUE);

        return instructorRepository.save(instructor);
    }

    public Instructor updateInstructor(Instructor inst) throws Exception {
        Instructor existingInstructor = instructorRepository.findById(inst.getId()).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            inst.setUpdatedDate(new Date());
            return instructorRepository.save(inst);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
    public void deleteInstructor(Integer id) throws Exception {
        Instructor existingInstructor = instructorRepository.findById(id).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            existingInstructor.setUpdatedDate(new Date());
            existingInstructor.setIsActive(Boolean.FALSE);
            instructorRepository.save(existingInstructor);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Instructor getCourseById(Integer id) throws Exception{
        Instructor existingInstructor = instructorRepository.findById(id).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            return existingInstructor;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

}
