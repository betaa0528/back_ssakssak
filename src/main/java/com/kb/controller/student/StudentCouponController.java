package com.kb.controller.student;

import com.kb.coupon.dto.BuyRequest;
import com.kb.coupon.dto.CouponDTO;
import com.kb.coupon.dto.StudentCouponDTO;
import com.kb.coupon.service.CouponService;
import com.kb.coupon.service.CouponUsageService;
import com.kb.member.dto.Member;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/student/coupon")
@RequiredArgsConstructor
@Slf4j
@Api(value = "StudentCouponController", tags = "쿠폰 상세 정보")
@PropertySource({"classpath:/application.properties"})
public class StudentCouponController {

    private final CouponService couponService;
    private final CouponUsageService couponUsageService;

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

    @PostMapping("/buy")
    public ResponseEntity<String> buyCoupon(@RequestBody BuyRequest request, @AuthenticationPrincipal Member member) {

        try {
            couponService.buyCoupon(request, member);
            return ResponseEntity.ok("쿠폰 구매가 완료되었습니다.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("쿠폰 구매 중 서버 오류가 발생했습니다.");
        }
    }

    @GetMapping("/mycp")
    public List<StudentCouponDTO> getStudentCoupons(@AuthenticationPrincipal Member member) {

        return couponService.getStudentCoupons(member);
    }

    @PostMapping("/use")
    public ResponseEntity<Void> useCoupon(@AuthenticationPrincipal Member member, @RequestBody String cpName) {
        couponUsageService.useCoupon(member, cpName);
        return ResponseEntity.ok().build();
    }


}