package com.example.attendance.controller;

import com.example.attendance.model.ExamModel;
import com.example.attendance.model.Examnative;
import com.example.attendance.repository.ExamRepository;
import com.example.attendance.service.AttendanceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/attendance")
@CrossOrigin(origins = "*")
public class ExamController {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    AttendanceService service;
    @Autowired
    ExamRepository er;
    static class CourseInput {
        public String courseId;
        public String name;
    }

    static class DurationInput {
        public String startDate;
        public String endDate;
    }
    @PostMapping("/postexam")
    public ResponseEntity<String> generateExam( @RequestParam("courses") String coursesJson, @RequestParam("duration") String durationJson ) {
        try {
            er.deleteAll();
            CourseInput[] courseInputs = objectMapper.readValue(coursesJson, CourseInput[].class);
            Map<String, String> courses = new LinkedHashMap<>();
            for (CourseInput input : courseInputs) {
                courses.put(input.courseId, input.name);
            }

            DurationInput duration = objectMapper.readValue(durationJson, DurationInput.class);
            LocalDate startDate = LocalDate.parse(duration.startDate);
            LocalDate endDate = LocalDate.parse(duration.endDate);

            return service.generateTimetable(courses, startDate, endDate);

//            return ResponseEntity.ok("Exam timetable generated and stored in database successfully");

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error generating timetable: " + e.getMessage());
        }
    }
    @GetMapping("/getexam")
    public List<ExamModel> getExam()
    {
        return service.findAll();
    }
    @GetMapping("/examsnative")
    public List<Examnative> getnativeexam(){
        return service.findnative();
    }
}
