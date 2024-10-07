package com.kb.student.service;

import com.kb.student.domain.Student;
import com.kb.student.dto.SeedRankingDTO;
import com.kb.student.dto.StudentCsvDTO;
import com.kb.student.dto.StudentDTO;
import com.kb.student.dto.DailyCheckDTO;
import com.kb.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j
public class StudentService {

    @Autowired
    private final StudentMapper studentMapper;

    // 학생 프로필 조회 (최근 5일간 출석 정보 포함)
    public StudentDTO getStudentProfile(Long studentId) {
        StudentDTO profile = studentMapper.selectStudentProfile(studentId);

        // 최근 5일간의 출석 정보 추가
        List<DailyCheckDTO> recentAttendance = studentMapper.selectRecentFiveDaysAttendance(studentId);
        profile.setRecentAttendance(recentAttendance);

        return profile;
    }

    //조은
    public List<SeedRankingDTO> getSeedRanking() {
        return studentMapper.getSeedRanking();
    }

    
    public void saveStudents(List<StudentCsvDTO> Student) {
        for (StudentCsvDTO studentcsvDTO : Student) {
            studentMapper.insertStudent(studentcsvDTO);
        }
    }
    public List<StudentCsvDTO> getAllStudents() {
        return studentMapper.getAllStudents();
    }
}