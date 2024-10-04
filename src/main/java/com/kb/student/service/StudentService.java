package com.kb.student.service;

import com.kb.student.dto.StudentDTO;
import com.kb.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentMapper studentMapper;

    public List<StudentDTO> getAllStudents() {
        return studentMapper.getStudentList();
    }

    public void registerStudent(StudentDTO studentDTO) {
        studentMapper.insertStudent(studentDTO);
    }
}