package com.codeline.SpringBoot.Controller;

import com.codeline.SpringBoot.RequestObject.InstructorCreateRequest;
import com.codeline.SpringBoot.Entities.Instructor;
import com.codeline.SpringBoot.Services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Instructor")
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @PostMapping("/create")
    public Instructor createInstructor(@RequestBody InstructorCreateRequest requestObj) throws Exception {
        InstructorCreateRequest.validCreateInstructorRequest(requestObj);
        Instructor instructor = instructorService.saveInstructor(requestObj);
        return instructor;
    }

    @GetMapping("/getAll")
    public List<Instructor> getAllInstructor(){
        List<Instructor> instructors= instructorService.getAllInstructor();
        return instructors;
    }

    @GetMapping("/getById/{id}")
    public Instructor getInstructorById(@PathVariable int id) throws Exception{
        return instructorService.getCourseById(id);
    }

    @PutMapping("/update")
    public Instructor updateInstructor(@RequestBody Instructor updateObjFromUser) throws Exception{
        return instructorService.updateInstructor(updateObjFromUser);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInstructor(@PathVariable int id) throws Exception{
        instructorService.deleteInstructor(id);
        return "Success";
    }
}
