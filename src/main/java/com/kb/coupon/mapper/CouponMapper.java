package com.kb.coupon.mapper;

import com.kb.coupon.domain.StudentCoupon;
import com.kb.coupon.dto.BuyRequest;
import com.kb.coupon.dto.CouponDTO;
import com.kb.coupon.dto.StudentCouponDTO;
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


    // 학생의 쿠폰 목록을 가져오며, 쿠폰 정보도 함께 가져옴
    List<StudentCouponDTO> getStudentCoupons(@Param("stdId") long stdId);

    // CouponDTO의 cpId와 StudentCouponDTO의 cpId가 일치하는 쿠폰 이름을 가져옴
    CouponDTO getCouponByCpId(@Param("cpId") long cpId);
}