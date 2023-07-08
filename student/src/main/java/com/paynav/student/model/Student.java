package com.paynav.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor  @AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;
    private String name;
    private String course;
    private String address;

    private String email;
    private Integer age;
    private String gender;
    private String parentName;
    private String parentPhone;
    private String admissionNumber;
    private LocalDateTime admissionDate;

    private String counseller;
}
