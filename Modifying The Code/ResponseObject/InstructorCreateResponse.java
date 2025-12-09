package com.codeline.SpringBoot.ResponseObject;

import com.codeline.SpringBoot.entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstructorCreateResponse {
    private int id;
    private String name;
    private String email;
    private String specialization;

    private Integer departmentId;
    private String departmentName;

    private Integer courseId;
    private String courseName;

    public static InstructorCreateResponse convertToInstructor(Instructor instructor) {

        return InstructorCreateResponse.builder()
                .id(instructor.getId())
                .name(instructor.getName())
                .email(instructor.getEmail())
                .specialization(instructor.getSpecialization())

                .departmentId(instructor.getDepartment().getId())
                .departmentName(instructor.getDepartment().getName())

                .courseId(instructor.getCourse().getId())
                .courseName(instructor.getCourse().getName())

                .build();
    }

}
