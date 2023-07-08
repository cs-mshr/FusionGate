package com.paynav.teacher.service;

import com.paynav.teacher.model.Teacher;
import com.paynav.teacher.repository.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import javax.persistence.Cacheable;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@EnableCaching
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepo repo;


    @Override
    public List<Teacher> getTeachers() {
        return repo.findAll();
    }

    @Override
    public Teacher getTeacher(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        teacher.setJoinedOn(LocalDateTime.now());
        return repo.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher updatedTeacher) {
        return repo.save(updatedTeacher);
    }

    @Override
    public void deleteTeacher(Integer id) {
        repo.deleteById(id);
    }
}
