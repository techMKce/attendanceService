package com.example.attendance.controller;

import com.example.attendance.model.Attcourse;
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
@RequestMapping("/api")
public class AttpercentContoller {

    @Autowired
    AttendanceService service;
    @GetMapping("/attpercent")
    public List<AttperModel> getattendance()
    {
        return service.attallpercent();
    }

    @GetMapping("/getstudent")
    public List<AttperModel> getstudentatt(@RequestParam String id)
    {
        return service.attstdper(id);
    }

    @GetMapping("/getfaculty")
    public List<AttendanceModel> getfacultyatt(@RequestParam String id,
                                               @RequestParam LocalDate date)
    {
        return service.attfac(id,date);
    }

    @GetMapping("/getfacultyy")
    public List<Attcourse> getfacultyatt(@RequestParam String id,
                                         @RequestParam LocalDate stdate,
                                         @RequestParam LocalDate endate)
    {
        return service.attfacy(id,stdate,endate);
    }

}
