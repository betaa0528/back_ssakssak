package com.kb.student.mapper;

import com.kb.student.domain.Student;
import com.kb.student.dto.DailyCheckDTO;
import com.kb.student.dto.SeedRankingDTO;
import com.kb.student.dto.StudentCsvDTO;
import com.kb.student.dto.StudentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    // 학생 프로필 조회
    StudentDTO selectStudentProfile(Long studentId);
    List<DailyCheckDTO> selectRecentFiveDaysAttendance(@Param("studentId") Long studentId);


    List<SeedRankingDTO> getSeedRanking();



    void insertStudent(StudentCsvDTO student);
    List<StudentCsvDTO> getAllStudents();
}