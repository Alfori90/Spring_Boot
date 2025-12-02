package com.codeline.SpringBoot.Services;

import com.codeline.SpringBoot.entities.Instructor;
import com.codeline.SpringBoot.entities.Mark;
import com.codeline.SpringBoot.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class MarkService {
    @Autowired
    MarkRepository markRepository;

    public List<Mark> getAllMark() {
        return markRepository.findAll();
    }

    public Mark saveMark(Mark mark) {
        mark.setCreateDate(new Date());
        mark.setIsActive(Boolean.TRUE);
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
