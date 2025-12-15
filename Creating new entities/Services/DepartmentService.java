package com.codeline.SpringBoot.Services;

import com.codeline.SpringBoot.Helper.Constants;
import com.codeline.SpringBoot.Helper.HelperUtils;
import com.codeline.SpringBoot.RequestObject.DepartmentCreateRequest;
import com.codeline.SpringBoot.Entities.Department;
import com.codeline.SpringBoot.Entities.Instructor;
import com.codeline.SpringBoot.repositories.CourseRepository;
import com.codeline.SpringBoot.repositories.DepartmentRepository;
import com.codeline.SpringBoot.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department saveDept(DepartmentCreateRequest request) throws Exception{
        Department dept = DepartmentCreateRequest.convertToDepartment(request);
        dept.setCreatedDate(new Date());
        dept.setIsActive(Boolean.TRUE);
        return departmentRepository.save(dept);
    }

    public Department updateDept(Department dept) throws Exception {
        Department existingDept = departmentRepository.findById(dept.getId()).get();
        if (existingDept != null && existingDept.getIsActive()) {
            dept.setUpdatedDate(new Date());
            return departmentRepository.save(dept);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
    public void deleteDept(Integer id) throws Exception {
        Department existingDept = departmentRepository.findById(id).get();
        if (existingDept != null && existingDept.getIsActive()) {
            existingDept.setUpdatedDate(new Date());
            existingDept.setIsActive(Boolean.FALSE);
            departmentRepository.save(existingDept);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Department getDeptById(Integer id) throws Exception {
        Department existingDept = departmentRepository.findById(id).get();
        if (existingDept != null && existingDept.getIsActive()) {
            return existingDept;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
}
