package com.kb.controller.teacher;

import com.kb.home.service.HomeService;
import com.kb.student.dto.StudentSalaryDTO;
import com.kb.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher/home")
@RequiredArgsConstructor
public class TeacherHomeController {

    private final HomeService homeService;
    private final StudentService studentService;

    @GetMapping("/total")
    public ResponseEntity<Integer> getTreasuryTotal() {
        int balance = homeService.getTreasuryTotal();
        return ResponseEntity.ok(balance);
    }
}