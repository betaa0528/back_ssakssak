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
public class CouponService {

    private final CouponMapper mapper;

    public List<CouponDTO> getAllCoupons() {
        List<CouponDTO> coupons = mapper.selectCoupon();
        return coupons;
    }

    public CouponDTO getCouponById(Long id) {
        CouponDTO coupon = mapper.selectCouponById(id);
        return coupon;
    }

    public void buyCoupon(Long couponId) {
        int result = mapper.updateCouponQuantity(couponId);
    }
}