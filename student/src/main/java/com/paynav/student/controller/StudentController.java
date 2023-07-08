package com.paynav.student.controller;

import com.paynav.student.model.Student;
import com.paynav.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  @RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;


    @GetMapping("/courses/{course_name}")
    public List<Student> getStudentsWithCourse(
            @PathVariable String course_name
    ){
        return studentService.studentWithCousre(course_name);
    }


    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }


    @PostMapping("/insert")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return new ResponseEntity(studentService.addStudent(student),HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student updatedCourse){
        return new ResponseEntity(studentService.updateStudent(updatedCourse),HttpStatus.OK);
    }


    @GetMapping("/{rollno}")
    public ResponseEntity<Student> getStudent(@PathVariable("rollno") String rollno){
        System.out.println(rollno);
        return ResponseEntity.ok(
                studentService.getStudent(
                        Integer.parseInt(rollno)
                )
        );
    }


    @DeleteMapping("/{rollno}")
    public ResponseEntity<String> deleteStudent(@PathVariable String rollno) {
        studentService.deleteStudent(Integer.parseInt(rollno));
        return ResponseEntity.ok("Course with roll number " + rollno + " has been deleted successfully.");
    }

}
