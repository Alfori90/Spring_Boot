package com.codeline.SpringBoot.Services;

import com.codeline.SpringBoot.Helper.HelperUtils;
import com.codeline.SpringBoot.RequestObject.CourseCreateRequest;
import com.codeline.SpringBoot.RequestObject.InstructorCreateRequest;
import com.codeline.SpringBoot.entities.Course;
import com.codeline.SpringBoot.entities.Department;
import com.codeline.SpringBoot.entities.Instructor;
import com.codeline.SpringBoot.entities.Mark;
import com.codeline.SpringBoot.repositories.CourseRepository;
import com.codeline.SpringBoot.repositories.DepartmentRepository;
import com.codeline.SpringBoot.repositories.InstructorRepositroy;
import com.codeline.SpringBoot.repositories.MarkRepository;
import com.codeline.Springboot.Helper.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InstructorService {
    @Autowired
    InstructorRepositroy instructorRepositroy;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    MarkRepository markRepository;

    public List<Instructor> getAllInstructor() {
        return instructorRepositroy.findAll();
    }

    public Instructor saveInstructor(InstructorCreateRequest request) throws Exception {
        Instructor instructor = InstructorCreateRequest.convertToInstructor(request);
        instructor.setCreateDate(new Date());
        instructor.setIsActive(Boolean.TRUE);

        Course course = courseRepository.getCourseById(request.getCourseId());
        if (HelperUtils.isNotNull(course)) {
            instructor.setCourse(course);
        } else {
            throw new Exception(Constants.INSTRUCTOR_CREATE_REQUEST_COURSE_ID_NOT_VALID);
        }

        Department department = departmentRepository.getDepartmentById(request.getDepartmentId());
        if (HelperUtils.isNotNull(department)) {
            instructor.setDepartment(department);
        } else {
            throw new Exception(Constants.INSTRUCTOR_CREATE_REQUEST_DEPARTMENT_ID_NOT_VALID);
        }

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
