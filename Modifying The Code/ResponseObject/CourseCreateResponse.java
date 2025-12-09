package com.codeline.SpringBoot.ResponseObject;

import com.codeline.SpringBoot.Services.MarkService;
import com.codeline.SpringBoot.entities.Course;
import com.codeline.SpringBoot.entities.Mark;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateResponse {

    private int id;
    private String name;
    private int creditHours;
    private String instructorName;
    private Integer instructorId;
    private Integer departmentId;
    private List<MarkCreateResponse> marks;


    public static CourseCreateResponse convertToCourse(Course entity) {
        CourseCreateResponse response = CourseCreateResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .creditHours(entity.getCreditHours())
                .instructorName(entity.getInstructor().getName())
                .instructorId(entity.getInstructor().getId())
                .departmentId(entity.getDepartment().getId())
                .build();
        return response;
    }

}
