package com.example.attendance.repository;

import com.example.attendance.model.Attcourse;
import com.example.attendance.model.AttendanceAllModel;
import com.example.attendance.model.AttendanceModel;
import com.example.attendance.model.AttperModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttpercentRepo extends JpaRepository<AttendanceModel , Long> {

    @Query(nativeQuery = true,
            value = "select " +
                     "batch," + "sem," +
                    "std_id as stdId," + "std_name as stdName," +
                    "dept_id as deptId," + "dept_name as deptName," +
                    "sum(status) as presentcount," +
                    "(count(dates)) as totaldays, " +
                    "ROUND((SUM(status)::decimal / count(dates)) * 100, 2) as percentage from attendance " +
                    "group by batch,sem,std_id,std_name,dept_id,dept_name;")
    public List<AttendanceAllModel> findAllPercent();


    @Query(nativeQuery = true,
            value = "select " + 
                    "batch, sem," +
                    "std_id as stdId," +
                    "std_name as stdName," +
                    "dept_id as deptId," +
                    "dept_name as deptName," +
                    "course_id as courseId," +
                    "course_name as courseName," +
                    "SUM(status) as presentcount," +
                    "count(dates) as totaldays, " +
                    "ROUND((SUM(status)::decimal / count(dates)) * 100, 2) as percentage " +
                    "from attendance " +
                    "where std_id=:id " +
                    "group by batch, sem, std_id, std_name, dept_id, dept_name, course_id, course_name;")
    public List<AttperModel> findBystdId(@Param("id") String id);



    @Query(nativeQuery = true,
            value = "select " +
                    "batch,sem," +
                    "std_id as stdId,std_name as stdName," +
                    "dept_id as deptId,dept_name as deptName," +
                    "faculty_id as facultyId,faculty_name as facultyName,"+
                    "course_id as courseId,course_name as courseName," +
                    "sum(status) as presentcount, (count(dates)) as totaldays," +
                    "ROUND((SUM(status)::decimal / count(dates)) * 100, 2) as percentage " +
                    " where faculty_id=:fid and course_id=:cid and (dates>=:stdate and dates<=:endate) " +
                    "group by std_id,std_name,dept_id,dept_name,batch,sem,course_id,course_name,faculty_id,faculty_name;")
    public List<Attcourse> findByfacIdAndDateBetween(
                                        @Param("fid") String facultyid,
                                        @Param("cid") String courseid,
                                       @Param("stdate") LocalDate stdate,
                                       @Param("endate") LocalDate endate);
}
