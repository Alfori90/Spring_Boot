package com.codeline.SpringBoot.Controller;

import com.codeline.SpringBoot.Services.CourseService;
import com.codeline.SpringBoot.RequestObject.CourseCreateRequest;
import com.codeline.SpringBoot.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("create")
    public Course createCourse(@RequestBody CourseCreateRequest requestObj) throws Exception{
       CourseCreateRequest.validCreateCourseRequest(requestObj);
        Course course = courseService.saveCourse(requestObj);
        return course;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @GetMapping("getAll")
    public List<Course> getAllCourse() {
        List<Course> courseList = courseService.getAllCourses();
        return courseList;
    }
    
    @GetMapping("getById/{id}")
    public Course getCourse(@PathVariable int id) throws Exception {

        return courseService.getCourseById(id);
    }

    @PutMapping("update")
    public Course updateCourse(@RequestBody Course updateObjFromUser) throws Exception {
        return courseService.updateCourse(updateObjFromUser);
    }


    @DeleteMapping("delete/{id}")
    public String deleteCourse(@PathVariable int id) throws Exception {
        courseService.deleteCourse(id);
        return "SUCCESS";

    }
}
