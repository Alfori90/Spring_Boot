package com.codeline.SpringBoot.Services;


import com.codeline.SpringBoot.Entities.Student;
import com.codeline.SpringBoot.RequestObject.StudentCreateRequest;
import com.codeline.SpringBoot.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student saveStudent(StudentCreateRequest student) {
        Student s = StudentCreateRequest.convertToStudent(student);
        s.setCreatedDate(new Date());
        s.setIsActive(Boolean.TRUE);
        return studentRepository.save(s);
    }

    public Student updateStudent(Student student) throws Exception {
        Student existingStudent = studentRepository.findById(student.getId()).get();
        if (existingStudent != null && existingStudent.getIsActive()) {
            student.setUpdatedDate(new Date());
            return studentRepository.save(student);
        } else {
            throw new
                    Exception("BAD REQUEST");
        }
    }

    public void deleteStudent(Integer id) throws Exception {
        Student existingStudent = studentRepository.findById(id).get();
        if (existingStudent != null && existingStudent.getIsActive()) {
            existingStudent.setUpdatedDate(new Date());
            existingStudent.setIsActive(Boolean.FALSE);
            studentRepository.save(existingStudent);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Student getStudentById(Integer id) throws Exception{
        Student existingStudent = studentRepository.findById(id).get();
        if (existingStudent != null && existingStudent.getIsActive()){
            return existingStudent;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
}
