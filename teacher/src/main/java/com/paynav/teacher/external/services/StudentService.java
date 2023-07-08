package com.paynav.teacher.external.services;

import com.paynav.teacher.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Open-FEIGN client for communicating to STUDENT service.
* */

@FeignClient(name = "STUDENT-APP")
public interface StudentService {
    @GetMapping("/students/courses/{courseName}")
    List<Student> getStudentsByTeacherId(@PathVariable String courseName);

    @GetMapping("/students/{rollno}")
    Student getStudentById(@PathVariable String rollno);

    @PutMapping("/students/update")
    Student updateStudent(@RequestBody Student updatedCourse);

    @DeleteMapping("students/{rollno}")
    public String deleteStudent(@PathVariable String rollno);
}
