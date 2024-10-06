package com.kb.student.service;

import com.kb.student.dto.StudentDTO;
import com.kb.student.dto.DailyCheckDTO;
import com.kb.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j
public class StudentService {

    private final StudentMapper studentMapper;

    public StudentDTO getStudentProfile(Long studentId) {
        StudentDTO profile = studentMapper.selectStudentProfile(studentId);

        List<DailyCheckDTO> recentAttendance = studentMapper.selectRecentFiveDaysAttendance(studentId);
        profile.setRecentAttendance(recentAttendance);

        return profile;
    }
}