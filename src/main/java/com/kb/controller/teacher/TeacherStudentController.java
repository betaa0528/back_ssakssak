package com.kb.controller.teacher;

import com.kb.member.dto.Member;
import com.kb.student.dto.StudentDTO;
import com.kb.student.dto.StudentResponse;
import com.kb.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/teacher/student")
@RequiredArgsConstructor
public class TeacherStudentController {

    private final StudentService studentService;

    @GetMapping("/list")
    public List<StudentResponse> getStudentList(@AuthenticationPrincipal Member member) throws IllegalAccessException {
        return studentService.getAllStudents(member.getUsername());
    }

    @PostMapping("/student-apply")
    public ResponseEntity<String> registerStudent(@RequestBody StudentDTO studentDTO) {
        studentService.registerStudent(studentDTO);
        return ResponseEntity.ok("Student registered successfully!");
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody StudentDTO studentDTO) {
        studentService.updateStudent(studentDTO);
        return "Student updated successfully!";

//     public ResponseEntity<String> updateStudentInfo(@RequestBody StudentDTO studentDTO) {
//         int result = studentService.updateStudentInfo(studentDTO);
//         if (result > 0) {
//             return ResponseEntity.ok("학생 정보가 성공적으로 업데이트되었습니다.");
//         } else {
//             return ResponseEntity.badRequest().body("학생 정보를 업데이트하지 못했습니다.");
//         }

    }
}