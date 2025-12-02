package com.codeline.SpringBoot.Controller;

import com.codeline.SpringBoot.Services.DepartmentService;
import com.codeline.SpringBoot.entities.Course;
import com.codeline.SpringBoot.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("createDepartment")
    public Department createDepartment(@RequestBody Department requestObj) {
        Department department = departmentService.saveDepartment(requestObj);
        return department;
    }

    @GetMapping("getAllDepartment")
    public List<Department> getAllDepartment() {
        List<Department> departmentList = departmentService.getAllDepartment();
        return departmentList;
    }


    @GetMapping("getDepartmentById/{id}")
    public Department getDepartment(@PathVariable int id) throws Exception {

        return departmentService.getDepartmentById(id);
    }

    @PutMapping("updateDepartment")
    public Department updateDepartment(@RequestBody Department updateObjFromUser) throws Exception {
        return departmentService.updateDepartment(updateObjFromUser);
    }


    @DeleteMapping("deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable int id) throws Exception {
        departmentService.deleteDepartment(id);
        return "SUCCESS";

    }
}
