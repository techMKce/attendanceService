package com.example.attendance.repository;

import com.example.attendance.model.ExamModel;
import com.example.attendance.model.Examnative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<ExamModel, Long> {
    @Query(nativeQuery = true,value = "select date,course_name,session from exam")
    public List<Examnative> findId();
}
