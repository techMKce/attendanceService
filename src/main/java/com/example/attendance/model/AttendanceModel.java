package com.example.attendance.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Entity
@Data
@Table(name="attendance")
@CrossOrigin(origins="*")
public class AttendanceModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String batch;
    private int sem;
    private String stdId;
    private String stdName;
    private String facultyId;
    private String facultyName;
    private String deptId;
    private String deptName;
    private String courseId;
    private String courseName;
    private String session;
    private int status;
    private LocalDate dates;
}
