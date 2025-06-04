package com.example.attendance.repository;

import com.example.attendance.model.AttendanceModel;
import com.example.attendance.model.AttperModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepo extends JpaRepository<AttendanceModel, Long> {
    Optional<AttendanceModel> findByStdIdAndDatesAndCourseId(String stdId, LocalDate dates,String courseId);

    Optional<AttendanceModel> findByStdIdAndDatesAndCourseIdAndSession(String stdId, LocalDate dates, String courseId, String session);

    @Query(nativeQuery = true,
            value = "select " +
                    "* from attendance " +
                    " where faculty_id=:fid and course_id=:cid and dates=:date ")
    public List<AttendanceModel> findByfacIdAndDate(@Param("fid") String facultyid,
                                         @Param("cid") String courseId,
                                         @Param("date") LocalDate date);


    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    value = "delete from attendance where course_id=:crsid")
    public void deleteBycourseId(@Param("crsid") String courseid);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "delete from attendance where std_id=:stdid")
    public void deleteBystudentId(@Param("stdid") String studentid);
}
