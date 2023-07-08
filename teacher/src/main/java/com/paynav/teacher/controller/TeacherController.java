package com.paynav.teacher.controller;

import com.netflix.discovery.converters.Auto;
import com.paynav.teacher.external.services.StudentService;
import com.paynav.teacher.model.Student;
import com.paynav.teacher.model.Teacher;
import com.paynav.teacher.service.TeacherService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
@EnableCaching
public class TeacherController {

//=========================Student-Management-Using-student-Microservice======================
//=========================Student-Management-Using-student-Microservice======================
//=========================Student-Management-Using-student-Microservice======================
//=========================Student-Management-Using-student-Microservice======================
//=========================Student-Management-Using-student-Microservice======================

    private final StudentService studentService;
    @GetMapping("/{teacher_id}/students")
    @CircuitBreaker(name = "student-fetch", fallbackMethod = "dummyStudent")
    @Retry(name = "student-fetch", fallbackMethod = "dummyStudent")
    @RateLimiter(name = "RateLimiter", fallbackMethod = "dummyStudent")
    @Cacheable(value = "first")
    public ResponseEntity<List<Student>> getStudentsByTeacherId(
            @PathVariable Integer teacher_id
    ){
        Teacher teacher = teacherService.getTeacher(teacher_id);
        return ResponseEntity.ok(studentService.getStudentsByTeacherId(teacher.getSubject()));
    }

    public ResponseEntity<List<Student>> dummyStudent(String userId, Exception ex) {
        Student student = new Student(5221, "Cshekhar", "BE", "456 Elm St", "csmshr@gmail.com", 20, "Male", "", "7894561230", "ADM-00100", LocalDateTime.now(), 3);
        return ResponseEntity.badRequest().body(List.of(student));
    }

    @PutMapping("/{teacher_id}/update-student")
    @CachePut(value = "first")
    public ResponseEntity<Student> updateStudent(
            @RequestBody Student student
    ){
        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    @DeleteMapping("/{teacher_id}/delete-student/{rollno}")
    @CacheEvict(value = "first", allEntries = true)
    public ResponseEntity<String> deleteStudent(
            @PathVariable String rollno
    ){
        Student student = studentService.getStudentById(rollno);
        studentService.deleteStudent(rollno);
        return ResponseEntity.ok( student.getName() + "deleted Sucessfully");
    }





//================================TeacherManagement===========================================-
//================================TeacherManagement===========================================-
//================================TeacherManagement===========================================-
//================================TeacherManagement===========================================-
//================================TeacherManagement===========================================-

    private final TeacherService teacherService;

    //Get all teachers
    @GetMapping
    @Cacheable
    public ResponseEntity<List<Teacher>> getTeachers(){
        return ResponseEntity.ok(teacherService.getTeachers());
    }

    // Insert a teacher
    @PostMapping("/insert")
    @Cacheable
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
        return new ResponseEntity(teacherService.addTeacher(teacher),HttpStatus.CREATED);
    }

    //Update teacher
    @PutMapping("/update")
    @CachePut(value="teacher")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher updatedTeacher){
        return new ResponseEntity(teacherService.updateTeacher(updatedTeacher),HttpStatus.CREATED);
    }

    // GET course using teacherID;
    @GetMapping("/{teacher_id}")
    @Cacheable
    public ResponseEntity<Teacher> getTeacher(@PathVariable String teacher_id){
        return ResponseEntity.ok(
                teacherService.getTeacher(
                        Integer.parseInt(teacher_id)
                )
        );
    }

    // Delete teacher;
    @DeleteMapping("/{rollno}")
    @CacheEvict(value = "first" , allEntries = true)
    public ResponseEntity<String> deleteTeacher(@PathVariable String teacher_id) {
        teacherService.deleteTeacher(Integer.parseInt(teacher_id));
        return ResponseEntity.ok("Teacher with roll number "
                + teacher_id +
                " has been deleted successfully.");
    }

}
