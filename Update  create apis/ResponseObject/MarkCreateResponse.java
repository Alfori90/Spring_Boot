package com.codeline.SpringBoot.ResponseObject;

import com.codeline.SpringBoot.entities.Mark;
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
    private String studentName;
    private Double score;
    private Integer courseId;
    private Integer instructorId;

    public static MarkCreateResponse convertToMark(Mark mark) {

        return MarkCreateResponse.builder()
                .id(mark.getId())
                .studentName(mark.getStudentName())
                .score(mark.getScore())
                .courseId(mark.getCourse().getId())
                .instructorId(mark.getInstructor().getId())
                .build();
    }

}
