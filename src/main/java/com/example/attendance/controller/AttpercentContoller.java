package com.example.attendance.controller;

import com.example.attendance.model.Attcourse;
import com.example.attendance.model.AttendanceAllModel;
import com.example.attendance.model.AttendanceModel;
import com.example.attendance.model.AttperModel;
import com.example.attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.util.List;
//import java.util.Map;

@RestController
@RequestMapping("/api/v1/attendance")
public class AttpercentContoller {

    @Autowired
    AttendanceService service;
    @GetMapping("/allattendancepercentage")
    public List<AttendanceAllModel> getattendance()
    {
        return service.attallpercent();
    }

    @GetMapping("/getstudentbyid")
    public List<AttperModel> getstudentatt(@RequestParam String id)
    {
        return service.attstdper(id);
    }

    @GetMapping("/getfacultybydate")
    public List<AttendanceModel> getfacultyatt(@RequestParam String facultyid,
                                               @RequestParam String courseid,
                                               @RequestParam LocalDate date)
    {
        return service.attfac(facultyid,courseid,date);
    }

    @GetMapping("/getfacultybydates")
    public List<Attcourse> getfacultyatt(@RequestParam String facultyid,
                                         @RequestParam String courseid,
                                         @RequestParam LocalDate stdate,
                                         @RequestParam LocalDate endate)
    {
        return service.attfacy(facultyid,courseid,stdate,endate);
    }

}
