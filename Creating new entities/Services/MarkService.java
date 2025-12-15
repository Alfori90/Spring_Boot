package com.codeline.SpringBoot.Services;

import com.codeline.SpringBoot.Entities.Student;
import com.codeline.SpringBoot.Helper.Constants;
import com.codeline.SpringBoot.Helper.HelperUtils;
import com.codeline.SpringBoot.RequestObject.MarkCreateRequest;
import com.codeline.SpringBoot.Entities.Course;
import com.codeline.SpringBoot.Entities.Instructor;
import com.codeline.SpringBoot.Entities.Mark;
import com.codeline.SpringBoot.repositories.CourseRepository;
import com.codeline.SpringBoot.repositories.InstructorRepository;
import com.codeline.SpringBoot.repositories.MarkRepository;
import com.codeline.SpringBoot.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class MarkService {
    @Autowired
    MarkRepository markRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<Mark> getAllMark() {
        return markRepository.findAll();
    }


    public Mark saveMark(MarkCreateRequest request) throws  Exception{
        Mark mark = MarkCreateRequest.convertToMark(request);
        mark.setCreatedDate(new Date());
        mark.setIsActive(Boolean.TRUE);

        Course course = courseRepository.getCourseById(request.getCourseId());
        if (HelperUtils.isNotNull(course)) {
            mark.setCourse(course);
        } else {
            throw new Exception(Constants.MARK_CREATE_REQUEST_COURSE_ID_NOT_VALID);
        }

        return markRepository.save(mark);
    }

    public Mark updateMark(Mark mark) throws Exception {
        Mark existingMark = markRepository.findById(mark.getId()).get();
        if (existingMark != null && existingMark.getIsActive()) {
            mark.setUpdatedDate(new Date());
            return markRepository.save(mark);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
    public void deleteMark(Integer id) throws Exception {
        Mark existingInstructor = markRepository.findById(id).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            existingInstructor.setUpdatedDate(new Date());
            existingInstructor.setIsActive(Boolean.FALSE);
            markRepository.save(existingInstructor);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Mark getMarkById(Integer id) throws Exception{
        Mark existingMark = markRepository.findById(id).get();
        if (existingMark != null && existingMark.getIsActive()) {
            return existingMark;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
}
