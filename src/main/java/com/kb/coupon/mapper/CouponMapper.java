package com.kb.coupon.mapper;

import com.kb.coupon.dto.CouponDTO;

import java.util.List;

public interface CouponMapper {
    List<CouponDTO> selectCoupon();
    CouponDTO selectCouponById(Long id);
    int updateCouponQuantity(Long couponId);
}