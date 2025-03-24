package com.kb.controller.teacher;

import com.kb.coupon.dto.CouponUsageDTO;
import com.kb.coupon.service.CouponService;
import com.kb.coupon.service.CouponUsageService;
import com.kb.home.service.HomeService;
import com.kb.member.dto.Member;
import com.kb.quiz.domain.Quiz;
import com.kb.quiz.service.QuizService;
import com.kb.student.dto.StudentSalaryDTO;
import com.kb.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/teacher/home")
public class TeacherHomeController {

    private final HomeService homeService;
    private final CouponUsageService couponUsageService;
    private final StudentService studentService;
    private final JobLauncher jobLauncher;
    private final Job maturityJob;
    private final CouponService couponService;

    public TeacherHomeController(HomeService homeService, CouponUsageService couponUsageService, StudentService studentService, JobLauncher jobLauncher, @Qualifier("maturityJob") Job maturityJob, CouponService couponService) {
        this.homeService = homeService;
        this.couponUsageService = couponUsageService;
        this.studentService = studentService;
        this.jobLauncher = jobLauncher;
        this.maturityJob = maturityJob;
        this.couponService = couponService;
    }

    @GetMapping("/total")
    public ResponseEntity<Integer> getTreasuryTotal() {
        int balance = homeService.getTreasuryTotal();
        return ResponseEntity.ok(balance);
    }

    @GetMapping("/usage")
    public ResponseEntity<Map<Object, Object>> getTodayUsage(@AuthenticationPrincipal Member member) {
        return ResponseEntity.ok(couponUsageService.getTodayCouponUsage(member));
    }

    @GetMapping("/write")
    public ResponseEntity<Void> write(@AuthenticationPrincipal Member member) {
        couponUsageService.testRedisWrite();
        return ResponseEntity.ok().build();
    }

}