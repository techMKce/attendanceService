package com.example.attendance.model;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
public interface Attcourse {
    String getBatch();
    int getSem();
    String getStdId();
    String getStdName();
    String getDeptId();
    String getDeptName();
    String getFacultyId();
    String getFacultyName();
    String getCourseId();
    String getCourseName();
    String getSession();
    int getPresentcount();
    int getTotaldays();
    float getPercentage();
}
