package com.example.attendance.controller;

import com.example.attendance.model.Attcourse;
import com.example.attendance.model.AttperModel;
import com.example.attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public List<Attcourse> getfacultyatt(@RequestParam String id)
    {
        return service.attfac(id);
    }

}
