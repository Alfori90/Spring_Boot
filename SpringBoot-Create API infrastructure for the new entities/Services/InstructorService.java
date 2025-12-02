package com.codeline.SpringBoot.Services;

import com.codeline.SpringBoot.entities.Course;
import com.codeline.SpringBoot.entities.Instructor;
import com.codeline.SpringBoot.repositories.CourseRepository;
import com.codeline.SpringBoot.repositories.InstructorRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InstructorService {
    @Autowired
    InstructorRepositroy instructorRepositroy;

    public List<Instructor> getAllInstructor() {
        return instructorRepositroy.findAll();
    }

    public Instructor saveInstructor(Instructor instructor) {
        instructor.setCreateDate(new Date());
        instructor.setIsActive(Boolean.TRUE);
        return instructorRepositroy.save(instructor);
    }

    public Instructor updateInstructor(Instructor instructor) throws Exception {
        Instructor existingInstructor = instructorRepositroy.findById(instructor.getId()).get();

        if (existingInstructor != null && existingInstructor.getIsActive()) {
            instructor.setUpdetedDate(new Date());
            return instructorRepositroy.save(instructor);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public void deleteInstructor(Integer id) throws Exception {
        Instructor existingInstructor = instructorRepositroy.findById(id).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            existingInstructor.setUpdetedDate(new Date());
            existingInstructor.setIsActive(Boolean.FALSE);
            instructorRepositroy.save(existingInstructor);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Instructor getInstructorById(Integer id) throws Exception {
        Instructor existingInstructor = instructorRepositroy.findById(id).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            return existingInstructor;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
}
