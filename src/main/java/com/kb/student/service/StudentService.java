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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j
public class StudentService {

    @Autowired
    private final StudentMapper studentMapper;

    public StudentDTO getStudentProfile(Long studentId) {
        StudentDTO profile = studentMapper.selectStudentProfile(studentId);

        List<DailyCheckDTO> recentAttendance = studentMapper.selectRecentFiveDaysAttendance(studentId);
        profile.setRecentAttendance(recentAttendance);

        return profile;
    }

    public void registerStudent(StudentDTO studentDTO) {
        studentMapper.insertStudent(studentDTO);
    }

    //조은
    public List<SeedRankingDTO> getSeedRanking() {
        return studentMapper.getSeedRanking();
    }
    public List<SeedRankingDTO> getSeedRankingThree() {
        return studentMapper.getSeedRankingThree();
    }

    @Transactional
    public void updateStudent(StudentDTO studentDTO) {
        studentMapper.updateStudent(studentDTO);

    }
    
    public void saveStudents(List<StudentCsvDTO> Student) {
        for (StudentCsvDTO studentcsvDTO : Student) {
            studentMapper.insertCSVStudent(studentcsvDTO);
        }
    }
    public List<StudentDTO> getAllStudents() {
        return studentMapper.getAllStudents();
    }

    public List<SeedRankingDTO> getStudentSeed() {
        return studentMapper.getStudentSeed();
    }


    public void giveSalaryToAllStudents(int seed) {
        studentMapper.updateAllStudentSeed(seed);
    }
}