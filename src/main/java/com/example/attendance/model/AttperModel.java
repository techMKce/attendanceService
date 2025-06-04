package com.example.attendance.model;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
public interface AttperModel {
    String getBatch();
    int getSem();
    String getStdId();
    String getStdName();
    String getDeptId();
    String getDeptName();
    String getCourseId();
    String getCourseName();
    int getPresentcount();
    int getTotaldays();
    float getPercentage();
}
