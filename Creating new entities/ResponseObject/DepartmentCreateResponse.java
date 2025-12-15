package com.codeline.SpringBoot.ResponseObject;

import com.codeline.SpringBoot.Entities.Course;
import com.codeline.SpringBoot.Entities.Department;
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
public class DepartmentCreateResponse {

    private Integer id;
    private String name;
    private String description;

    public static DepartmentCreateResponse convertToDepartmentResponse(Department entity) {
        DepartmentCreateResponse response = DepartmentCreateResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
        return response;
    }
}
