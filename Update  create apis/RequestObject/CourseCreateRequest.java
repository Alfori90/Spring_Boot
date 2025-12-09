package com.codeline.SpringBoot.RequestObject;

import com.codeline.SpringBoot.entities.Course;
import com.codeline.SpringBoot.entities.Mark;
import com.codeline.Springboot.Helper.Constants;
import com.codeline.SpringBoot.Helper.HelperUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateRequest {

    private String name;
    private int creditHours;
    private Integer instructorId;
    private Integer departmentId;
    private List<Mark> marks;


    public static Course convertToCourse(CourseCreateRequest request) {
        Course course = new Course();
        course.setName(request.getName());
        course.setCreditHours(request.getCreditHours());
        return course;
    }

    public static void validCreateCourseRequest(CourseCreateRequest request) throws Exception {
        if (HelperUtils.isNull(request.getName()) || request.getName().isBlank() || request.getName().isEmpty()) {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_NAME_NOT_VALID);
        } else if (HelperUtils.isNull(request.getCreditHours()) || request.getCreditHours() <= Constants.LOWEST_CREDIT_HOURS || request.getCreditHours() >= Constants.HIGHEST_CREDIT_HOURS) {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_CREDIT_HOURS_NOT_VALID);
        } else if (HelperUtils.isNull(request.getInstructorId()) || request.getInstructorId() <= 0) {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        } else if (HelperUtils.isNull(request.getDepartmentId()) || request.getDepartmentId() <= 0) {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_DEPARTMENT_ID_NOT_VALID);
        } else if (HelperUtils.isNotNull(request.getMarks()) || HelperUtils.isListEmpty(request.getMarks())) {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_MARK_NOT_VALID);
        }
    }
}
