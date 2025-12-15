package com.codeline.SpringBoot.Controller;

import com.codeline.SpringBoot.RequestObject.DepartmentCreateRequest;
import com.codeline.SpringBoot.Entities.Department;
import com.codeline.SpringBoot.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Department")

public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/create")
    public Department createDept(@RequestBody DepartmentCreateRequest requestObj) throws Exception{
        DepartmentCreateRequest.validCreateDepartmentRequest(requestObj);
        Department dept = departmentService.saveDept(requestObj);
        return dept;
    }

    @GetMapping("/getAll")
    public List<Department> getAllDept(){
        List<Department> deptList= departmentService.getAllDepartment();
        return deptList;
    }

    @GetMapping("/getById/{id}")
    public Department getDeptById(@PathVariable int id) throws Exception{
        return departmentService.getDeptById(id);
    }

    @PutMapping("/update")
    public Department updateDept(@RequestBody Department updateObjFromUser) throws Exception{
        return departmentService.updateDept(updateObjFromUser);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDept(@PathVariable int id) throws Exception{
        departmentService.deleteDept(id);
        return "Success";
    }
}
