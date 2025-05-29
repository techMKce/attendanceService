package com.example.attendance.service;

import com.example.attendance.model.Attcourse;
import com.example.attendance.model.AttendanceModel;
import com.example.attendance.model.AttperModel;
import com.example.attendance.repository.AttendanceRepo;
import com.example.attendance.repository.AttpercentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import java.util.*;
import java.util.Map;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    AttendanceRepo attrepo;

    @Autowired
    AttpercentRepo attperrepo;

    public void addattendance(AttendanceModel attendance) {
        attrepo.save(attendance);
    }

    public Optional<AttendanceModel> findByStdIdAndDated(String stdId, LocalDate dates,String courseId) {
        return attrepo.findByStdIdAndDatesAndCourseId(stdId,dates,courseId);
    }


    public List<AttperModel> attallpercent() {
        return attperrepo.findAllPercent();
    }

    public List<AttperModel> attstdper(String id) {
        return attperrepo.findBystdId(id);
    }

    public List<AttendanceModel> attfac(String id, LocalDate date) { return attrepo.findByfacIdAndDate(id,date);}

    public List<Attcourse> attfacy(String id, LocalDate stdate, LocalDate endate)
    {
            return attperrepo.findByfacIdAndDateBetween(id,stdate,endate);
    }




//
//    static class TimeSlot {
//        LocalDate date;
//        String session;
//        TimeSlot(LocalDate date, String session) {
//            this.date = date;
//            this.session = session;
//        }
//        @Override
//        public String toString() {
//            return date.toString() + " - " + session;
//        }
//    }
//
//    public void generateTimetable(Map<String, String> courses, LocalDate startDate, String filename)throws IOException {
//
//        String[] sessions = {"Morning", "Afternoon"};
//        Random random = new Random();
//
//        List<TimeSlot> timeSlots = new ArrayList<>();
//        LocalDate currentDate = startDate;
//        int courseIndex = 0;
//
//        while (courseIndex < courses.size()) {
//            if (currentDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
//                String randomSession = sessions[random.nextInt(sessions.length)];
//                timeSlots.add(new TimeSlot(currentDate, randomSession));
//                courseIndex++;
//                currentDate = currentDate.plusDays(2); // 1 day gap between exams
//            } else {
//                currentDate = currentDate.plusDays(1);
//            }
//        }
//
//        List<String> courseCodes = new ArrayList<>(courses.keySet());
//        Collections.shuffle(courseCodes);
//        Map<String, TimeSlot> courseSchedule = new LinkedHashMap<>();
//        for (int i = 0; i < courseCodes.size(); i++) {
//            courseSchedule.put(courseCodes.get(i), timeSlots.get(i));
//        }
//
//        try (FileWriter writer = new FileWriter(filename)) {
//            writer.write("Date,Session,Course Code,Course Name\n");
//            for (var entry : courseSchedule.entrySet()) {
//                TimeSlot slot = entry.getValue();
//                String courseCode = entry.getKey();
//                String courseName = courses.get(courseCode);
//                writer.write(String.format("%s,%s,%s,%s\n", slot.date, slot.session, courseCode, courseName));
//            }
//        }
//    }

}


