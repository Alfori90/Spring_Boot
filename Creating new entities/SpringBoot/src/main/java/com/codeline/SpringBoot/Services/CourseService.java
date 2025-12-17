package com.codeline.SpringBoot.Services;

import com.codeline.SpringBoot.Entities.Department;
import com.codeline.SpringBoot.Helper.Constants;
import com.codeline.SpringBoot.Helper.HelperUtils;
import com.codeline.SpringBoot.RequestObject.CourseCreateRequest;
import com.codeline.SpringBoot.Entities.Course;
import com.codeline.SpringBoot.Entities.Instructor;
import com.codeline.SpringBoot.Entities.Mark;
import com.codeline.SpringBoot.ResponseObject.CourseCreateResponse;
import com.codeline.SpringBoot.repositories.CourseRepository;
import com.codeline.SpringBoot.repositories.DepartmentRepository;
import com.codeline.SpringBoot.repositories.InstructorRepository;
import com.codeline.SpringBoot.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    DepartmentRepository departmentRepository;


    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseCreateResponse saveCourse(CourseCreateRequest request) throws Exception {
        Course course = CourseCreateRequest.convertToCourse(request);
        course.setCreatedDate(new Date());
        course.setIsActive(Boolean.TRUE);

        Instructor instructor = instructorRepository.getInstructorById(request.getInstructorId());
        //if instructor not found, create new instructor
        if (HelperUtils.isNull(instructor)) {
            Instructor newInstructor = new Instructor();
            newInstructor.setName(request.getName());
            newInstructor.setCreatedDate(new Date());
            newInstructor.setIsActive(Boolean.TRUE);

            // Department, check if exists, else create new
            Department department = departmentRepository.getDepartmentById(request.getDepartmentId());
            if (HelperUtils.isNull(department)) {
                Department newDepartment = new Department();
                newDepartment.setName(request.getName());
                newDepartment.setCreatedDate(new Date());
                newDepartment.setIsActive(Boolean.TRUE);
                department = departmentRepository.save(newDepartment);
            }
            newInstructor.setDepartment(department);

            instructor = instructorRepository.save(newInstructor);
        }
        // set instructor to course, whether existing or newly created
        course.setInstructor(instructor);

        if (HelperUtils.isNotNull(request.getMarks()) && !request.getMarks().isEmpty()) {
            List<Mark> marks = new ArrayList<>();


            course.setMarks(marks);
        } else {
            throw new Exception(Constants.INSTRUCTOR_COURSE_ID_NOT_FOUND);
        }

        Course savedCourse = courseRepository.save(course);

        return CourseCreateResponse.convertToCourseResponse(savedCourse);
    }


    public Course updateCourse(Course course) throws Exception {
        Course existingCourse = courseRepository.findById(course.getId()).get();
        if (existingCourse!=null && existingCourse.getIsActive()) {
            course.setUpdatedDate(new Date());
            return courseRepository.save(course);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public void deleteCourse(Integer id) throws Exception {
        Course existingCourse = courseRepository.findById(id).get();
        if (existingCourse != null && existingCourse.getIsActive()) {
            existingCourse.setUpdatedDate(new Date());
            existingCourse.setIsActive(Boolean.FALSE);
            courseRepository.save(existingCourse);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Course getCourseById(Integer id) throws Exception{
        Course existingCourse = courseRepository.findById(id).get();
        if (existingCourse != null && existingCourse.getIsActive()){
            return existingCourse;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

}
