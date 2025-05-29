package com.example.attendance.service;

import com.example.attendance.model.*;
import com.example.attendance.repository.AttendanceRepo;
import com.example.attendance.repository.AttpercentRepo;
import com.example.attendance.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    AttendanceRepo attrepo;

    @Autowired
    AttpercentRepo attperrepo;
    @Autowired
    ExamRepository er;

    public void addattendance(AttendanceModel attendance) {
        attrepo.save(attendance);
    }

    public Optional<AttendanceModel> findByStdIdAndDated(String stdId, LocalDate dates,String courseId)
    {
        return attrepo.findByStdIdAndDatesAndCourseId(stdId,dates,courseId);
    }

    public List<AttperModel> attallpercent() {
        return attperrepo.findAllPercent();
    }

    public List<AttperModel> attstdper(String id) {
        return attperrepo.findBystdId(id);
    }

    public List<Attcourse> attfac(String id)
    {
        return attperrepo.findByfacId(id);
    }

    public List<Examnative> findnative(){
        return er.findId();
    }
    public List<ExamModel> findAll(){
        return er.findAll();
    }

    public void generateTimetable(Map<String, String> courses, LocalDate startDate, LocalDate endDate) {
            String[] sessions = {"Forenoon", "Afternoon"};
            String[] timeSlots = {"9:00-12:00", "1:00-4:00"};
            
            Random random = new Random();
    
            List<String> courseCodes = new ArrayList<>(courses.keySet());
            Collections.shuffle(courseCodes);
    
            LocalDate currentDate = startDate;
            int scheduledCoursesCount = 0;
    
            for (String courseId : courseCodes) {
                String courseName = courses.get(courseId);
                boolean slotFoundForThisCourse = false;
    

                while (!slotFoundForThisCourse && !currentDate.isAfter(endDate)) {
                    if (currentDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
                        int sessionIndex = random.nextInt(sessions.length);
                        String randomSession = sessions[sessionIndex];
                        String randomTimeSlot = timeSlots[sessionIndex];

                        ExamModel exam = new ExamModel();
                        exam.setCourseId(courseId);
                        exam.setCourseName(courseName);
                        exam.setSession(randomSession);
                        exam.setTimeSlot(randomTimeSlot);
                        exam.setDate(currentDate);

                        er.save(exam);

    
                        scheduledCoursesCount++;
                        slotFoundForThisCourse = true;

                        currentDate = currentDate.plusDays(2);
                    } else {
                        currentDate = currentDate.plusDays(1);
                    }
                }
    
                if (!slotFoundForThisCourse) {
                    System.err.println("Warning: Could not schedule course '" + courseId + "' (" + courseName + ") and subsequent courses. End date reached or no suitable slots found.");
                break;
            }
        }

        if (scheduledCoursesCount == courseCodes.size()) {
            System.out.println("Successfully scheduled all " + scheduledCoursesCount + " courses.");
        } else {
            System.out.println("Warning: Not all courses were scheduled. Scheduled " + scheduledCoursesCount + " out of " + courseCodes.size() + " courses within the given date range.");
        }
    }


}
