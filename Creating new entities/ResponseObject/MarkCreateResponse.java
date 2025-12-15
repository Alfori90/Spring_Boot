package com.codeline.SpringBoot.ResponseObject;

import com.codeline.SpringBoot.Entities.Mark;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarkCreateResponse {
    private int id;

    private Double score;
    private Integer courseId;


    public static MarkCreateResponse convertToMarkResponse(Mark entity) {
        MarkCreateResponse response = MarkCreateResponse.builder()
                .id(entity.getId())
                .score(entity.getScore())
                .courseId(entity.getCourse().getId())
                .build();
        return response;
    }

}
