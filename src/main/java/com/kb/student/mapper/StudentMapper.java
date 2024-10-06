package com.kb.student.mapper;

import com.kb.student.dto.DailyCheckDTO;
import com.kb.student.dto.StudentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentDTO selectStudentProfile(Long studentId);
    List<DailyCheckDTO> selectRecentFiveDaysAttendance(@Param("studentId") Long studentId);
}