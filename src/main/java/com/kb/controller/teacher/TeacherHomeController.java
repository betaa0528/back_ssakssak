package com.kb.controller.teacher;

import com.kb.home.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teacher/home")
@RequiredArgsConstructor
public class TeacherHomeController {

    private final HomeService homeService;

    @GetMapping("/total")
    public ResponseEntity<Integer> getTreasuryTotal() {
        int balance = homeService.getTreasuryTotal();
        return ResponseEntity.ok(balance);
    }
}