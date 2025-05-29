//package com.example.attendance.controller;
//
//import com.example.attendance.service.AttendanceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api")
//public class ExamController {
//
//    @Autowired
//    AttendanceService service;
//    @GetMapping("/postexam")
//    public ResponseEntity<String> genreateexam() {
//        Map<String, String> courses = new LinkedHashMap<>();
//        courses.put("CS101", "Computer Science Basics");
//        courses.put("CS102", "Data Structures");
//        courses.put("MATH101", "Calculus");
//        courses.put("EC101", "Basic Electronics");
//        courses.put("PHY101", "Physics");
//        courses.put("ME101", "Mechanics");
//        courses.put("CE101", "Civil Engineering Fundamentals");
//
//        LocalDate startDate = LocalDate.of(2025, 6, 1);
//        String filename = "exam_timetable.csv";
//
//        try {
//            service.generateTimetable(courses, startDate, filename);
//            return ResponseEntity.ok("Timetable generated as " + filename);
//        } catch (IOException e) {
//            return ResponseEntity.status(500).body("Error generating timetable: " + e.getMessage());
//        }
//    }
//}
