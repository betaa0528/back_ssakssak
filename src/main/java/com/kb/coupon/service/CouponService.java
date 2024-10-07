package com.kb.coupon.service;

import com.kb.alarm.service.AlarmService;
import com.kb.coupon.dto.CouponDTO;
import com.kb.coupon.mapper.CouponMapper;
import com.kb.member.dto.Member;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
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

    private final CouponMapper couponMapper;
    private final StudentMapper studentMapper;
    private final AlarmService alarmService;

    public List<CouponDTO> getAllCoupons() {
        List<CouponDTO> coupons = couponMapper.selectCoupon();
        return coupons;
    }

    public CouponDTO getCouponById(Long id) {
        CouponDTO coupon = couponMapper.selectCouponById(id);
        return coupon;
    }

    public void buyCoupon(Long couponId, Member member) {
        Student student = studentMapper.selectStudentByUsernameAndStdName(member.getUsername(), member.getName());
        StringBuilder sb = new StringBuilder();
        CouponDTO couponDTO = couponMapper.selectCouponById(couponId);
        sb.append(member.getName()).append("학생이 ").append(couponDTO.getCpName()).append("을 구매했어요");
        alarmService.sendAlarm(student.getTchId(), sb.toString());
        int result = couponMapper.updateCouponQuantity(couponId);
    }
}