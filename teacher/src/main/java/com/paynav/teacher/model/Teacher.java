package com.paynav.teacher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor  @AllArgsConstructor
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacher_id;
    private String name;
    private String subject;
    private String phone;
    private String address;

    private LocalDateTime joinedOn;
    private String email;
    private String qualification;
    private int experience;
    private double salary;
}
