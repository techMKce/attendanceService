package com.example.attendance.repository;

import com.example.attendance.model.AttendanceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface AttendanceRepo extends JpaRepository<AttendanceModel, Long>
{
    Optional<AttendanceModel> findByStdIdAndDatesAndCourseId(String stdId, LocalDate dates,String courseId);
}
