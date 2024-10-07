package com.kb.controller.student;

import com.kb.coupon.dto.CouponDTO;
import com.kb.coupon.service.CouponService;
import com.kb.member.dto.Member;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/coupon")
@RequiredArgsConstructor
@Slf4j
@Api(value = "StudentCouponController", tags = "쿠폰 상세 정보")
@PropertySource({"classpath:/application.properties"})
public class StudentCouponController {

    private final CouponService couponService;

    @GetMapping("/list")
    public ResponseEntity<List<CouponDTO>> getCoupons() {
        List<CouponDTO> coupons = couponService.getAllCoupons();
        return ResponseEntity.ok(coupons);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<CouponDTO> getCouponById(@PathVariable Long id) {
        CouponDTO coupon = couponService.getCouponById(id);
        return ResponseEntity.ok(coupon);
    }

    @PostMapping("/buy/{couponId}")
    public ResponseEntity<String> buyCoupon(@PathVariable Long couponId, @AuthenticationPrincipal Member principal) {

        couponService.buyCoupon(couponId, principal);

//        long tchId = couponService.get
        return ResponseEntity.ok("Coupon purchased successfully!");
    }
}