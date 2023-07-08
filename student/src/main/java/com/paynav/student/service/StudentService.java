package com.paynav.student.service;

import com.paynav.student.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService{
    List<Student> getStudents();
    Student getStudent(Integer id);

    Student addStudent(Student student);

    Student updateStudent(Student updatedStudent);

    void deleteStudent(Integer id);

    List<Student> studentWithCousre(String courseName);
}