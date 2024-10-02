package com.kb.controller.student;

import com.kb.coupon.dto.CouponDTO;
import com.kb.coupon.service.CouponService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/coupon")
@RequiredArgsConstructor
@Slf4j
@Api(value = "StudentCouponController", tags = "쿠폰 상세 정보")
@PropertySource({"classpath:/application.properties"})
public class StudentCouponController {

    private final CouponService CouponService;

    @GetMapping("/list")
    public ResponseEntity<List<CouponDTO>> getCoupons() {
        List<CouponDTO> coupons = CouponService.getAllCoupons();
        return ResponseEntity.ok(coupons);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<CouponDTO> getCouponById(@PathVariable Long id) {
        CouponDTO coupon = CouponService.getCouponById(id);
        return ResponseEntity.ok(coupon);
    }

    @PostMapping("/buy/{couponId}")
    public ResponseEntity<String> buyCoupon(@PathVariable Long couponId) {
        CouponService.buyCoupon(couponId);
        return ResponseEntity.ok("Coupon purchased successfully!");
    }
}