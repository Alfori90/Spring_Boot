package com.codeline.SpringBoot.RequestObject;

import com.codeline.SpringBoot.Helper.HelperUtils;
import com.codeline.SpringBoot.entities.Mark;
import com.codeline.Springboot.Helper.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarkCreateRequest {
    private String studentName;
    private Double score;
    private Integer courseId;
    private Integer instructorId;

    public static Mark convertToMark(MarkCreateRequest request) {
        Mark mark = new Mark();
        mark.setStudentName(request.getStudentName());
        mark.setScore(request.getScore());
        return mark;
    }

    public static void validCreateMarkRequest(MarkCreateRequest request) throws Exception {
        if (HelperUtils.isNull(request.getStudentName()) || request.getStudentName().isBlank() || request.getStudentName().isEmpty()) {
            throw new Exception(Constants.MARK_CREATE_REQUEST_STUDENT_NAME_NOT_VALID);
        }
        else if (HelperUtils.isNull(request.getScore()) || request.getScore() < 0 || request.getScore() > 100) {
            throw new Exception(Constants.MARK_CREATE_REQUEST_SCORE_NOT_VALID);
        }
        else if (HelperUtils.isNull(request.getCourseId()) || request.getCourseId() <= 0) {
            throw new Exception(Constants.MARK_CREATE_REQUEST_COURSE_ID_NOT_VALID);
        }
        else if (HelperUtils.isNull(request.getInstructorId()) || request.getInstructorId() <= 0) {
            throw new Exception(Constants.MARK_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }
    }

}
