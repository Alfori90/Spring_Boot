package com.codeline.SpringBoot.ResponseObject;

import com.codeline.SpringBoot.ResponseObject.MarkCreateResponse;
import com.codeline.SpringBoot.Entities.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateResponse {

    private int id;
    private String name;
    private int creditHours;
    private Integer instructorId;
    private List<MarkCreateResponse> marks;

    public static CourseCreateResponse convertToCourseResponse(Course entity) {
        CourseCreateResponse response = CourseCreateResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .creditHours(entity.getCreditHours())
                .instructorId(entity.getInstructor().getId())
                .marks(entity.getMarks()==null ? null :
                        entity.getMarks()
                                .stream()
                                .map(MarkCreateResponse::convertToMarkResponse)
                                .collect(Collectors.toList()))
                .build();
        return response;
    }
}
