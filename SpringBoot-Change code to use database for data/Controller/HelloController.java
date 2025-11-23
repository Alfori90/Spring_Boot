package com.codeline.SpringBoot.Controller;

import com.codeline.SpringBoot.Services.CourseService;
import com.codeline.SpringBoot.entities.Course;
import com.codeline.SpringBoot.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController

public class HelloController {

    @Autowired
    CourseService courseService;

    @PostMapping("create")
    public Course createCourse(@RequestBody Course requestObj) {
        Course course = courseService.saveCourse(requestObj);
        return course;
    }

    @GetMapping("getAll")
    public List<Course> getAllCourse() {
        List<Course> courseList = courseService.getAllCourse();
        return courseList;
    }


    @GetMapping("getById")
    public Course getCourse(@RequestParam int id) throws Exception {

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
