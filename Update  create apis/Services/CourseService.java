package com.codeline.SpringBoot.Services;

import com.codeline.SpringBoot.entities.Course;
import com.codeline.SpringBoot.entities.Department;
import com.codeline.SpringBoot.entities.Instructor;
import com.codeline.SpringBoot.entities.Mark;
import com.codeline.SpringBoot.repositories.CourseRepository;
import com.codeline.SpringBoot.repositories.DepartmentRepository;
import com.codeline.SpringBoot.repositories.InstructorRepositroy;
import com.codeline.SpringBoot.repositories.MarkRepository;
import com.codeline.SpringBoot.RequestObject.CourseCreateRequest;
import com.codeline.Springboot.Helper.Constants;
import com.codeline.SpringBoot.Helper.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructorRepositroy instructorRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    MarkRepository markRepository;


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

        Department department = departmentRepository.getDepartmentById(request.getDepartmentId());
        if (HelperUtils.isNotNull(department)){
           course.setDepartment(department);
        } else{
            throw new  Exception(Constants.COURSE_CREATE_REQUEST_DEPARTMENT_ID_NOT_VALID);
        }

        List<Mark> marks= markRepository.getMarkByStudentName(request.getMarks());
        if(HelperUtils.isNotNull(marks)&& HelperUtils.isListNotEmpty(marks)){
            course.setMarks(marks);
        }else{
            throw new  Exception(Constants.COURSE_CREATE_REQUEST_MARK_NOT_VALID);
        }
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course) throws Exception {
        Course existingCourse = courseRepository.findById(course.getId()).get();

        if (existingCourse != null && existingCourse.getIsActive()) {
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

    public Course getCourseById(Integer id) throws Exception {
        Course existingCourse = courseRepository.findById(id).get();

        existingCourse.getInstructor().getDepartment().getDescription();
        if (existingCourse != null && existingCourse.getIsActive()) {
            return existingCourse;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
}

