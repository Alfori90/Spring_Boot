package com.codeline.SpringBoot.RequestObject;

import com.codeline.SpringBoot.Helper.HelperUtils;
import com.codeline.SpringBoot.Entities.Mark;
import com.codeline.SpringBoot.Helper.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarkCreateRequest {
    private Integer studentId;
    private Integer courseId;
    private Double score;

    public static Mark convertToMark(MarkCreateRequest request) {
        Mark mark = new Mark();
        if (request!=null) {
            mark.setScore(request.getScore());
        }
        return mark;
    }
    public static void validCreateMarkRequest(MarkCreateRequest request) throws Exception {
        if (HelperUtils.isNull(request.getStudentId()) || request.getStudentId()<=0) {
            throw new Exception(Constants.MARK_CREATE_REQUEST_STUDENT_ID_NOT_VALID);
        }
        else if (HelperUtils.isNull(request.getScore()) || request.getScore() < 0 || request.getScore() > 100) {
            throw new Exception(Constants.MARK_CREATE_REQUEST_SCORE_NOT_VALID);
        }
        else if (HelperUtils.isNull(request.getCourseId()) || request.getCourseId() <= 0) {
            throw new Exception(Constants.MARK_CREATE_REQUEST_COURSE_ID_NOT_VALID);
        }
    }
}
