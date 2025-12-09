package com.codeline.SpringBoot.RequestObject;

import com.codeline.SpringBoot.Helper.HelperUtils;
import com.codeline.Springboot.Helper.Constants;
import com.codeline.SpringBoot.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentCreateRequest {
    private String name;
    private String description;
    private Integer courseId;
    private Integer instructorId;

    public static Department convertToDepartment(DepartmentCreateRequest request) {
        Department department = new Department();
        department.setName(request.getName());
        department.setDescription(request.getDescription());
        return department;
    }

    public static void validCreateDepartmentRequest(DepartmentCreateRequest request) throws Exception {
        if (HelperUtils.isNull(request.getName()) || request.getName().isBlank() || request.getName().isEmpty()) {
            throw new Exception(Constants.DEPARTMENT_CREATE_REQUEST_NAME_NOT_VALID);
        } else if (HelperUtils.isNull(request.getDescription()) || request.getDescription().isBlank() || request.getDescription().isEmpty()) {
            throw new Exception(Constants.DEPARTMENT_CREATE_REQUEST_DESCRIPTION_NOT_VALID);
        } else if (HelperUtils.isNull(request.getCourseId()) || request.getCourseId() <= 0) {
            throw new Exception(Constants.DEPARTMENT_CREATE_REQUEST_COURSE_ID_NOT_VALID);
        } else if (HelperUtils.isNull(request.getInstructorId()) || request.getInstructorId() <= 0) {
            throw new Exception(Constants.DEPARTMENT_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }
    }

}
