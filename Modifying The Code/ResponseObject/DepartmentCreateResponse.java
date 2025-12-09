package com.codeline.SpringBoot.ResponseObject;

import com.codeline.SpringBoot.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentCreateResponse {
    private int id;
    private String name;
    private String description;
    private Integer instructorId;
    private String instructorName;

    public static DepartmentCreateResponse convertToDepartment(Department department) {

        return DepartmentCreateResponse.builder()
                .id(department.getId())
                .name(department.getName())
                .description(department.getDescription())
                .instructorId(department.getInstructor().getId())
                .instructorName(department.getInstructor().getName())
                .build();
    }
}
