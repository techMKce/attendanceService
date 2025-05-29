package com.example.attendance.model;

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
    int getPresentcount();
    int getTotaldays();
    float getPercentage();
}
