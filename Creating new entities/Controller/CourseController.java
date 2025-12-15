package com.codeline.SpringBoot.Controller;


import com.codeline.SpringBoot.RequestObject.CourseCreateRequest;
import com.codeline.SpringBoot.Entities.Course;
import com.codeline.SpringBoot.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Course")
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
    @GetMapping("/getAll")
    public List<Course> getAllCourses(){
    List<Course> courses= courseService.getAllCourses();
    return courses;
    }

    @GetMapping("/getById/{id}")
    public Course getCourseById(@PathVariable int id) throws Exception{
        return courseService.getCourseById(id);
    }

    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course updateObjFromUser) throws Exception{
        return courseService.updateCourse(updateObjFromUser);
    }

    @DeleteMapping("/delete/{id}")
   public String deleteCourse(@PathVariable int id) throws Exception{
        courseService.deleteCourse(id);
        return "Success";
   }

}
