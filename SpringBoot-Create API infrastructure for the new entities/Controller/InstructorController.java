package com.codeline.SpringBoot.Controller;

import com.codeline.SpringBoot.Services.InstructorService;
import com.codeline.SpringBoot.entities.Course;
import com.codeline.SpringBoot.entities.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController

public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @PostMapping("createInstructor")
    public Instructor createInstructor(@RequestBody Instructor requestObj) {
        Instructor instructor = instructorService.saveInstructor(requestObj);
        return instructor;
    }

    @GetMapping("getAllInstructor")
    public List<Instructor> getAllInstructor() {
        List<Instructor> instructorList = instructorService.getAllInstructor();
        return instructorList;
    }


    @GetMapping("getInstructorById/{id}")
    public Instructor getInstructor(@PathVariable int id) throws Exception {

        return instructorService.getInstructorById(id);
    }

    @PutMapping("updateInstructor")
    public Instructor updateInstructor(@RequestBody Instructor updateObjFromUser) throws Exception {
        return instructorService.updateInstructor(updateObjFromUser);
    }


    @DeleteMapping("deleteInstructor/{id}")
    public String deleteInstructor(@PathVariable int id) throws Exception {
        instructorService.deleteInstructor(id);
        return "SUCCESS";

    }

}
