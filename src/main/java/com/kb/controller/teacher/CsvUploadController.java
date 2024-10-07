package com.kb.controller.teacher;


import com.kb.student.dto.StudentCsvDTO;
import com.kb.student.service.StudentService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
@Slf4j
@Api(value = "StudentGrade", tags = "학생 학급 등록")
@PropertySource({"classpath:/application.properties"})
public class CsvUploadController {
    private final StudentService studentService;

    @PostMapping("/class")
    public ResponseEntity<String> uploadCsv(@RequestBody List<StudentCsvDTO> students) {
        studentService.saveStudents(students);
        return ResponseEntity.ok("CSV data uploaded and saved successfully");
    }

//    @GetMapping("/class/student")
//    public List<StudentCsvDTO> getAllStudents() {
//        return studentService.getAllStudents();
//    }
}