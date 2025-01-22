package com.kb.controller.teacher;


import com.kb.member.dto.Member;
import com.kb.student.dto.StudentCsvDTO;
import com.kb.student.dto.StudentDTO;
import com.kb.student.service.StudentService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

//    @PostMapping("/class")
//    public ResponseEntity<String> uploadCsv(@RequestBody List<StudentCsvDTO> students) {
//        studentService.saveStudents(students);
//        return ResponseEntity.ok("CSV data uploaded and saved successfully");
//    }


    @PostMapping("/class")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("파일이 비어 있습니다.");
            }

            List<StudentCsvDTO> students = parseCsvFile(file);
            studentService.saveStudents(students);
            return ResponseEntity.ok("CSV 데이터가 성공적으로 업로드되고 저장되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("CSV 업로드에 실패했습니다.");
        }
    }

    private List<StudentCsvDTO> parseCsvFile(MultipartFile file) throws Exception {
        List<StudentCsvDTO> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    // 헤더 라인 건너뛰기
                    isFirstLine = false;
                    continue;
                }
                String[] tokens = line.split(",");
                if (tokens.length >= 5) {
                    StudentCsvDTO student = new StudentCsvDTO();
                    student.setStdNum(Integer.parseInt(tokens[0].trim()));
                    student.setStdName(tokens[1].trim());
                    student.setStdBirth(tokens[2].trim());
                    student.setJobId(Long.parseLong(tokens[3].trim()));
                    student.setSeed(Integer.parseInt(tokens[4].trim()));
                    student.setTchId(1L); // tchId를 1로 고정
                    students.add(student);
                }
            }
        }

        return students;
    }

    @GetMapping("/class/student")
    public List<StudentDTO> getAllStudents(@AuthenticationPrincipal Member member) {
        return studentService.getAllStudents(member.getUsername());
    }
}