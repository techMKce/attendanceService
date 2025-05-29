package com.example.attendance.model;

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
