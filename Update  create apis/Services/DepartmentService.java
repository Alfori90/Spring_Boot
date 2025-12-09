package com.codeline.SpringBoot.Services;

import com.codeline.SpringBoot.Helper.HelperUtils;
import com.codeline.SpringBoot.RequestObject.DepartmentCreateRequest;
import com.codeline.SpringBoot.RequestObject.InstructorCreateRequest;
import com.codeline.SpringBoot.entities.Course;
import com.codeline.SpringBoot.entities.Department;
import com.codeline.SpringBoot.entities.Instructor;
import com.codeline.SpringBoot.entities.Mark;
import com.codeline.SpringBoot.repositories.CourseRepository;
import com.codeline.SpringBoot.repositories.DepartmentRepository;
import com.codeline.SpringBoot.repositories.InstructorRepositroy;
import com.codeline.Springboot.Helper.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    InstructorRepositroy instructorRepositroy;

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department saveDepartment(DepartmentCreateRequest request) throws Exception {
        Department department = DepartmentCreateRequest.convertToDepartment(request);
        department.setCreatedDate(new Date());
        department.setIsActive(Boolean.TRUE);

        Instructor instructor = instructorRepositroy.getInstructorById(request.getInstructorId());
        if (HelperUtils.isNotNull(instructor)) {
            department.setInstructor(instructor);
        } else {
            throw new Exception(Constants.DEPARTMENT_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }

        return departmentRepository.save(department);
    }

    public Department updateDepartment(Department department) throws Exception {
        Department existingDepartment = departmentRepository.findById(department.getId()).get();

        if (existingDepartment != null && existingDepartment.getIsActive()) {
            department.setUpdatedDate(new Date());
            return departmentRepository.save(department);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public void deleteDepartment(Integer id) throws Exception {
        Department existingDepartment = departmentRepository.findById(id).get();
        if (existingDepartment != null && existingDepartment.getIsActive()) {
            existingDepartment.setUpdatedDate(new Date());
            existingDepartment.setIsActive(Boolean.FALSE);
            departmentRepository.save(existingDepartment);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Department getDepartmentById(Integer id) throws Exception {
        Department existingDepartment = departmentRepository.findById(id).get();
        if (existingDepartment != null && existingDepartment.getIsActive()) {
            return existingDepartment;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
}
