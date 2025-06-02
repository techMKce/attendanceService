package com.example.attendance.repository;

import com.example.attendance.model.AttendanceModel;
import com.example.attendance.model.AttperModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepo extends JpaRepository<AttendanceModel, Long> {
    Optional<AttendanceModel> findByStdIdAndDatesAndCourseId(String stdId, LocalDate dates,String courseId);

    Optional<AttendanceModel> findByStdIdAndDatesAndCourseIdAndSession(String stdId, LocalDate dates, String courseId, String session);

    @Query(nativeQuery = true,
            value = "select " +
                    "* from attendance " +
                    " where faculty_id=:id and dates=:date ")
    public List<AttendanceModel> findByfacIdAndDate(@Param("id") String id,
                                         @Param("date") LocalDate date);


}
