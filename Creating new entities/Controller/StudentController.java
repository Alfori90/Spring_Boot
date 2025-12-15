package com.codeline.SpringBoot.Controller;


import com.codeline.SpringBoot.Entities.Address;
import com.codeline.SpringBoot.Entities.PhoneNumber;
import com.codeline.SpringBoot.Entities.Student;
import com.codeline.SpringBoot.RequestObject.StudentCreateRequest;
import com.codeline.SpringBoot.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Student createStudent(@RequestBody StudentCreateRequest requestObj) {
        Student student = studentService.saveStudent(requestObj);
        return student;
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        return students;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) throws Exception {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}/update")
    public Student updateStudent(@RequestBody Student updateObjFromUser) throws Exception {
        return studentService.updateStudent(updateObjFromUser);
    }

    @DeleteMapping("/{id}/delete")
    public String deleteStudent(@PathVariable int id) throws Exception {
        studentService.deleteStudent(id);
        return "Success";
    }
}
