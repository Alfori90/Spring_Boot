package com.codeline.SpringBoot.Services;

import com.codeline.SpringBoot.Helper.Constants;
import com.codeline.SpringBoot.Helper.HelperUtils;
import com.codeline.SpringBoot.RequestObject.CourseCreateRequest;
import com.codeline.SpringBoot.Entities.Course;
import com.codeline.SpringBoot.Entities.Instructor;
import com.codeline.SpringBoot.Entities.Mark;
import com.codeline.SpringBoot.repositories.CourseRepository;
import com.codeline.SpringBoot.repositories.DepartmentRepository;
import com.codeline.SpringBoot.repositories.InstructorRepository;
import com.codeline.SpringBoot.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Course saveCourse(CourseCreateRequest request) throws Exception {
        Course course=CourseCreateRequest.convertToCourse(request);
        course.setCreatedDate(new Date());
        course.setIsActive(Boolean.TRUE);

        Instructor instructor = instructorRepository.getInstructorById(request.getInstructorId());
        if (HelperUtils.isNotNull(instructor)){
            course.setInstructor(instructor);
        } else{
            throw new  Exception(Constants.COURSE_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }

        return courseRepository.save(course);
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
