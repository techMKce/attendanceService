package com.example.attendance.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.Date;
@Data
@Entity
@Table(name="exam")
public class ExamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String courseId;
    private String courseName;
    private String session;
    private String TimeSlot;
    private LocalDate date;

}
