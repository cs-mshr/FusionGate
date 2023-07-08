package com.paynav.teacher.repository;

import com.paynav.teacher.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher,Integer> {
}
