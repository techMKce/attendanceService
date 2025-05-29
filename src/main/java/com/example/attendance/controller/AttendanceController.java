package com.example.attendance.controller;

import com.example.attendance.model.AttendanceModel;
import com.example.attendance.service.AttendanceService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AttendanceController {

    @Autowired
    AttendanceService service;
    @PostMapping("/attupdate")
    public String addattendance(@RequestBody List<AttendanceModel> attendance)
    {
        StringBuilder result = new StringBuilder();
        for(AttendanceModel att : attendance)
        {
            Optional<AttendanceModel> exists = service.findByStdIdAndDated(att.getStdId(),att.getDates(),att.getCourseId());
            if(exists.isPresent())
            {
                AttendanceModel at;
                at=exists.get();
                at.setStatus(att.getStatus());
                service.addattendance(at);
                result.append("Updated Successfully\n");
            }
            else
            {
                service.addattendance(att);
                result.append("Inserted successfully\n");
            }
        }
        return result.toString();
    }
}
