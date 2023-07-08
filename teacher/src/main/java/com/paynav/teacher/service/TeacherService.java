package com.paynav.teacher.service;

import com.paynav.teacher.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    List<Teacher> getTeachers();
    Teacher getTeacher(Integer id);
    Teacher addTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher updatedTeacher);
    void deleteTeacher(Integer id);
}
