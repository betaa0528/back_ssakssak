package com.kb.coupon.service;

import com.kb.alarm.dto.AlarmArgs;
import com.kb.alarm.dto.AlarmType;
import com.kb.alarm.service.AlarmService;
import com.kb.coupon.dto.CouponAlarmArgs;
import com.kb.coupon.dto.CouponDTO;
import com.kb.coupon.mapper.CouponMapper;
import com.kb.member.dto.Member;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

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
        CouponDTO coupon = couponMapper.selectAvailableCouponById(id);
        return coupon;
    }

    @Transactional
    public void buyCoupon(Long couponId, Member member) {
        Student student = studentMapper.selectStudentByUsernameAndStdName(member.getUsername(), member.getName());
        CouponDTO couponDTO = couponMapper.selectAvailableCouponById(couponId);

        AlarmArgs alarmArgs = new CouponAlarmArgs(AlarmType.COUPON_BUY, couponDTO.getCpName());
        String alarmMsg = alarmArgs.getAlarmType().createMessage(alarmArgs);
        StringBuilder sb = new StringBuilder(member.getName()).append(alarmMsg);
        alarmService.sendAlarm(student.getTchId(), sb.toString(), AlarmType.COUPON_BUY, couponId);
        int result = couponMapper.updateCouponQuantity(couponId);

        if(result != 1) {
            throw new NoSuchElementException("쿠폰 수량이 제대로 업데이트 되지 않았습니다.");
        }
    }
}