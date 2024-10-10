package com.kb.coupon.mapper;

import com.kb.coupon.domain.StudentCoupon;
import com.kb.coupon.dto.BuyRequest;
import com.kb.coupon.dto.CouponDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponMapper {
    List<CouponDTO> selectCoupon();

    CouponDTO selectAvailableCouponById(Long id);

    CouponDTO selectCouponById(Long id);

    int updateCouponQuantity(BuyRequest request);

    int insertStudentCoupon(@Param("stdId") long stdId, @Param("cpId") long cpId, @Param("quantity") int quantity);

    StudentCoupon selectStudentCoupon(@Param("stdId") long stdId, @Param("cpId") long cpId);

    void updateStudentCoupon(@Param("stdId") long stdId, @Param("cpId") long cpId, @Param("quantity") int quantity);
}