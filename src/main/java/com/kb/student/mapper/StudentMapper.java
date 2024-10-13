

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
    List<StudentDTO> getStudentList();
    void insertStudent(StudentDTO studentDTO);
    // 학생 프로필 조회
    StudentDTO selectStudentProfile(Long studentId);
    List<DailyCheckDTO> selectRecentFiveDaysAttendance(@Param("studentId") Long studentId);
    int updateStudentSeed(@Param("stdId") long stdId, @Param("changeSeed") int changeSeed);


    //조은
    List<SeedRankingDTO> getSeedRanking();
    List<SeedRankingDTO> getSeedRankingThree();

    void insertCSVStudent(StudentCsvDTO student);
    List<StudentDTO> getAllStudents();
    List<SeedRankingDTO> getStudentSeed();
    int getStudentCount();

    void updateAllStudentSeed(@Param("seed") int seed);
    void updateStudent(@Param("student") StudentDTO student);

    Student selectStudentById(long stdId);
    Student selectStudentByUsernameAndStdName(@Param("username") String username,@Param("name") String name);
    StudentDTO selectStudentByUsernameAndName(@Param("username") String username,@Param("name") String name);
}