package com.kb.controller.teacher;

import com.kb.coupon.service.CouponUsageService;
import com.kb.home.service.HomeService;
import com.kb.member.dto.Member;
import com.kb.quiz.domain.Quiz;
import com.kb.quiz.service.QuizService;
import com.kb.student.dto.StudentSalaryDTO;
import com.kb.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/teacher/home")
@RequiredArgsConstructor
public class TeacherHomeController {

    private final HomeService homeService;
    private final CouponUsageService couponUsageService;

    @GetMapping("/total")
    public ResponseEntity<Integer> getTreasuryTotal() {
        int balance = homeService.getTreasuryTotal();
        return ResponseEntity.ok(balance);
    }

    @GetMapping("/usage")
    public ResponseEntity<Map<Object, Object>> getTodayUsage(@AuthenticationPrincipal Member member) {
        return ResponseEntity.ok(couponUsageService.getTodayCouponUsage(member));
    }
}