package com.paynav.student.repository;

import com.paynav.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    @Query(value = "SELECT * FROM student WHERE course = :courseName",nativeQuery = true)
    public List<Student> findByCourse(String courseName);
}
