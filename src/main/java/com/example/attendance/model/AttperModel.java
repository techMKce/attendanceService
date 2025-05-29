package com.example.attendance.model;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
public interface AttperModel {
    String getBatch();
    int getSem();
    String getStdId();
    String getStdName();
    String getSession();
    String getDeptId();
    String getDeptName();
    int getPresentcount();
    int getTotaldays();
    float getPercentage();
}
