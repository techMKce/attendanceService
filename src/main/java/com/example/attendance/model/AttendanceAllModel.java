package com.example.attendance.model;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
public interface AttendanceAllModel {
    String getBatch();
    int getSem();
    String getStdId();
    String getStdName();
    String getDeptId();
    String getDeptName();
    int getPresentcount();
    int getTotaldays();
    float getPercentage();
}
