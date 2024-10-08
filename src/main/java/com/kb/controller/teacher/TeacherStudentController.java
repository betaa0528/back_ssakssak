package com.kb.controller.teacher;

import com.kb.student.dto.StudentDTO;
import com.kb.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher/student")
@RequiredArgsConstructor
public class TeacherStudentController {

    private final StudentService studentService;

    @GetMapping("/list")
    public List<StudentDTO> getStudentList() {
        return studentService.getAllStudents();
    }

    @PostMapping("/student-apply")
    public ResponseEntity<String> registerStudent(@RequestBody StudentDTO studentDTO) {
        studentService.registerStudent(studentDTO);
        return ResponseEntity.ok("Student registered successfully!");
    }
}