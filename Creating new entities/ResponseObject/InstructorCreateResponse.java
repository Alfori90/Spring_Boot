package com.codeline.SpringBoot.ResponseObject;
import com.codeline.SpringBoot.Entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstructorCreateResponse {
    private Integer id;
    private String name;
    private String email;
    private String specialization;

    public static InstructorCreateResponse convertToInstructorResponse(Instructor entity) {
        InstructorCreateResponse response = InstructorCreateResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .specialization(entity.getSpecialization())
                .build();
        return response;
    }
}
