package com.kb.controller.teacher;

import com.kb.teacher.dto.TeacherDTO;
import com.kb.teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUpTeacher(@RequestBody TeacherDTO teacherDTO) {
        try {
            teacherService.signUpTeacher(teacherDTO);
            return ResponseEntity.ok("Sign-up successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/find-id")
    public ResponseEntity<String> findTeacherId(@RequestBody TeacherDTO teacherDTO) {
        String teacherId = teacherService.findTeacherIdByNameAndEmail(teacherDTO);
        if (teacherId != null) {
            return ResponseEntity.ok("Teacher ID: " + teacherId);
        }
        return ResponseEntity.badRequest().body("No matching teacher account exists.");
    }

    @PostMapping("/find-pw")
    public ResponseEntity<String> checkTeacherAccount(@RequestBody TeacherDTO teacherDTO) {
        boolean accountExists = teacherService.checkTeacherAccount(teacherDTO);
        if (accountExists) {
            return ResponseEntity.ok("Account verified successfully.");
        }
        return ResponseEntity.badRequest().body("No matching account information found.");
    }

    @PostMapping("/reset-pw")
    public ResponseEntity<String> resetTeacherPassword(@RequestBody TeacherDTO teacherDTO) {
        try {
            boolean accountExists = teacherService.checkTeacherAccount(teacherDTO);
            if (accountExists) {
                teacherService.resetTeacherPassword(teacherDTO);
                return ResponseEntity.ok("Password reset successfully!");
            }
            return ResponseEntity.badRequest().body("The account information is invalid.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}