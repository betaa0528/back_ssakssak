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

    // 모든 학생에게 입력된 주급을 지급하는 엔드포인트
    @PostMapping("/give")
    public ResponseEntity<String> giveSalaryToAllStudents(@RequestBody StudentSalaryDTO studentSalaryDTO) {
        studentService.giveSalaryToAllStudents(studentSalaryDTO.getSeed());
        return ResponseEntity.ok("주급이 모든 학생들에게 지급되었습니다.");
    }

    @PostMapping("/pay-salary")
    public ResponseEntity<String> paySalary(@RequestBody StudentSalaryDTO studentSalaryDTO) {
        homeService.paySalaryToStudents(studentSalaryDTO);
        return ResponseEntity.ok("주급이 모든 학생들에게 지급되었고, 국고에서 차감되었습니다.");
    }
}