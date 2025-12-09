package com.codeline.SpringBoot.Services;

import com.codeline.SpringBoot.Helper.HelperUtils;
import com.codeline.SpringBoot.RequestObject.InstructorCreateRequest;
import com.codeline.SpringBoot.RequestObject.MarkCreateRequest;
import com.codeline.SpringBoot.entities.Course;
import com.codeline.SpringBoot.entities.Instructor;
import com.codeline.SpringBoot.entities.Mark;
import com.codeline.SpringBoot.repositories.CourseRepository;
import com.codeline.SpringBoot.repositories.InstructorRepositroy;
import com.codeline.SpringBoot.repositories.MarkRepository;
import com.codeline.Springboot.Helper.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class MarkService {
    @Autowired
    MarkRepository markRepository;
    @Autowired
    InstructorRepositroy instructorRepository;
@Autowired
CourseRepository courseRepository;

    public List<Mark> getAllMark() {
        return markRepository.findAll();
    }

    public Mark saveMark(MarkCreateRequest request) throws  Exception{
        Mark mark = MarkCreateRequest.convertToMark(request);
        mark.setCreateDate(new Date());
        mark.setIsActive(Boolean.TRUE);

        Course course = courseRepository.getCourseById(request.getCourseId());
        if (HelperUtils.isNotNull(course)) {
            mark.setCourse(course);
        } else {
            throw new Exception(Constants.MARK_CREATE_REQUEST_COURSE_ID_NOT_VALID);
        }

        Instructor instructor = instructorRepository.getInstructorById(request.getInstructorId());
        if (HelperUtils.isNotNull(instructor)) {
            mark.setInstructor(instructor);
        } else {
            throw new Exception(Constants.MARK_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }

        return markRepository.save(mark);
    }

    public Mark updateMark(Mark mark) throws Exception {
        Mark existingMark = markRepository.findById(mark.getId()).get();

        if (existingMark != null && existingMark.getIsActive()) {
            mark.setUpdetedDate(new Date());
            return markRepository.save(mark);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public void deleteMark(Integer id) throws Exception {
        Mark existingMark = markRepository.findById(id).get();
        if (existingMark != null && existingMark.getIsActive()) {
            existingMark.setUpdetedDate(new Date());
            existingMark.setIsActive(Boolean.FALSE);
            markRepository.save(existingMark);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Mark getMarkById(Integer id) throws Exception {
        Mark existingMark = markRepository.findById(id).get();
        if (existingMark != null && existingMark.getIsActive()) {
            return existingMark;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

}
