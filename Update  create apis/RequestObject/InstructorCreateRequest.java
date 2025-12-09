package com.codeline.SpringBoot.RequestObject;

import com.codeline.SpringBoot.entities.Instructor;
import com.codeline.SpringBoot.Helper.HelperUtils;
import com.codeline.Springboot.Helper.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstructorCreateRequest {

    private String name;
    private String email;
    private String specialization;
    private Integer departmentId;
    private Integer courseId;

    public static Instructor convertToInstructor(InstructorCreateRequest request) {
        Instructor instructor = new Instructor();
        instructor.setName(request.getName());
        instructor.setEmail(request.getEmail());
        instructor.setSpecialization(request.getSpecialization());
        return instructor;
    }


    public static void validCreateInstructorRequest(InstructorCreateRequest request) throws Exception {
        if (HelperUtils.isNull(request.getName()) || request.getName().isBlank() || request.getName().isEmpty()) {
            throw new Exception(Constants.INSTRUCTOR_CREATE_REQUEST_NAME_NOT_VALID);
        } else if (HelperUtils.isNull(request.getEmail()) || request.getEmail().isBlank() || !request.getEmail().contains("@")) {
            throw new Exception(Constants.INSTRUCTOR_CREATE_REQUEST_EMAIL_NOT_VALID);
        } else if (HelperUtils.isNull(request.getSpecialization()) || request.getSpecialization().isBlank()) {
            throw new Exception(Constants.INSTRUCTOR_CREATE_REQUEST_SPECIALIZATION_NOT_VALID);
        }
        else if (HelperUtils.isNull(request.getDepartmentId()) || request.getDepartmentId() <= 0) {
            throw new Exception(Constants.INSTRUCTOR_CREATE_REQUEST_DEPARTMENT_ID_NOT_VALID);
        }
        else if (HelperUtils.isNotNull(request.getCourseId()) && request.getCourseId() <= 0) {
            throw new Exception(Constants.INSTRUCTOR_CREATE_REQUEST_COURSE_ID_NOT_VALID);
        }
    }
}

