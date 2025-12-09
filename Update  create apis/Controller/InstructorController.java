package com.codeline.SpringBoot.Controller;

import com.codeline.SpringBoot.RequestObject.CourseCreateRequest;
import com.codeline.SpringBoot.RequestObject.InstructorCreateRequest;
import com.codeline.SpringBoot.Services.InstructorService;
import com.codeline.SpringBoot.entities.Course;
import com.codeline.SpringBoot.entities.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Instructor")
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @PostMapping("create")
    public Instructor createInstructor(@RequestBody InstructorCreateRequest requestObj) throws Exception {
        InstructorCreateRequest.validCreateInstructorRequest(requestObj);
        Instructor instructor = instructorService.saveInstructor(requestObj);
        return instructor;
    }

    @GetMapping("getAll")
    public List<Instructor> getAllInstructor() {
        List<Instructor> instructorList = instructorService.getAllInstructor();
        return instructorList;
    }


    @GetMapping("getById/{id}")
    public Instructor getInstructor(@PathVariable int id) throws Exception {

        return instructorService.getInstructorById(id);
    }

    @PutMapping("update")
    public Instructor updateInstructor(@RequestBody Instructor updateObjFromUser) throws Exception {
        return instructorService.updateInstructor(updateObjFromUser);
    }


    @DeleteMapping("delete/{id}")
    public String deleteInstructor(@PathVariable int id) throws Exception {
        instructorService.deleteInstructor(id);
        return "SUCCESS";

    }

}
