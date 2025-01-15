    package com.kb.student.mapper;

import com.kb.student.domain.Student;
import com.kb.student.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    // 배치용
    List<StudentDTO> getStudentListByJobId();



    // ================================
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

    void updateAllStudentSeed(int pay);
    void updateStudent(@Param("student") StudentDTO student);
    void updateStudentJob(@Param("stdId") long stdId,@Param("jobId") long jobId);

    Student selectStudentById(long stdId);
    Student selectStudentByUsernameAndStdName(@Param("username") String username,@Param("name") String name);
    StudentDTO selectStudentByUsernameAndName(@Param("username") String username,@Param("name") String name);

    List<StudentSalaryDTO> selectStudentBaseSalary();
    List<StudentSalaryDTO> selectStudentAdditionalSalary();

}