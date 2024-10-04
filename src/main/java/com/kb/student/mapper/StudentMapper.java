package com.kb.student.mapper;

import com.kb.student.dto.StudentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<StudentDTO> getStudentList();
    void insertStudent(StudentDTO studentDTO);
}