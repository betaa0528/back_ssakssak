package com.kb.coupon.service;

import com.kb.coupon.dto.CouponDTO;
import com.kb.coupon.mapper.CouponMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.properties"})
public class storeservice {

    private final CouponMapper mapper;

    public List<CouponDTO> getAllCoupons() {
        List<CouponDTO> coupons = mapper.selectCoupon();
        log.info(coupons);
        return coupons;
    }

    public CouponDTO getCouponById(Long id) {
        CouponDTO coupon = mapper.selectCouponById(id);
        log.info("Coupon retrieved: " + coupon);
        return coupon;
    }

    public void buyCoupon(Long couponId) {
        int result = mapper.updateCouponQuantity(couponId);
        if (result > 0) {
            log.info("Coupon purchased successfully: " + couponId);
        } else {
            log.error("Coupon purchase failed for ID: " + couponId);
        }
    }
}