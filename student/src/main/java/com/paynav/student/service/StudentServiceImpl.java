package com.paynav.student.service;

import com.paynav.student.model.Student;
import com.paynav.student.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service  @RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepo repo;
    @Override
    public List<Student> getStudents() {
        return repo.findAll();
    }

    @Override
    public Student getStudent(Integer id) {
        return repo.findById(id).get();
    }


    @Override
    public Student addStudent(Student student) {
        student.setAdmissionDate(LocalDateTime.now());
        return repo.save(student);
    }

    @Override
    public Student updateStudent(Student updatedStudent) {
        return repo.save(updatedStudent);
    }

    @Override
    public void deleteStudent(Integer rollno) {
        repo.deleteById(rollno);
    }

    @Override
    public List<Student> studentWithCousre(String courseName) {
        return repo.findByCourse(courseName);
    }

}
