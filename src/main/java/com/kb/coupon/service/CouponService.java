package com.kb.coupon.service;

import com.kb.alarm.dto.AlarmArgs;
import com.kb.alarm.dto.AlarmType;
import com.kb.alarm.service.AlarmService;
import com.kb.coupon.domain.StudentCoupon;
import com.kb.coupon.dto.BuyRequest;
import com.kb.coupon.dto.CouponDTO;
import com.kb.coupon.dto.StudentCouponDTO;
import com.kb.coupon.mapper.CouponMapper;
import com.kb.kafka.KafkaProducer;
import com.kb.member.dto.Member;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import com.kb.teacher.mapper.TeacherMapper;
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
@PropertySource({"classpath:/application.yml"})
public class CouponService {

    private final CouponMapper couponMapper;
    private final StudentMapper studentMapper;
    private final AlarmService alarmService;
    private final TeacherMapper teacherMapper;
    private final KafkaProducer kafkaProducer;

    public List<CouponDTO> getAllCoupons() {
        List<CouponDTO> coupons = couponMapper.selectCoupon();
        return coupons;
    }

    public CouponDTO getCouponById(Long id) {
        CouponDTO coupon = couponMapper.selectAvailableCouponById(id);
        return coupon;
    }

    @Transactional(rollbackFor = Exception.class)
    public void buyCoupon(BuyRequest request, Member member) {
        Student student = studentMapper.selectStudentByUsernameAndStdName(member.getUsername(), member.getName());
        CouponDTO couponDTO = couponMapper.selectAvailableCouponById(request.getCpId());

        if (student.getSeed() < request.getAmount()) {
            throw new NoSuchElementException("씨드가 부족합니다.");
        }

        int result = couponMapper.updateCouponQuantity(request);
        if (result != 1) {
            throw new NoSuchElementException("쿠폰 구매에 실패했습니다.");
        }
        StudentCoupon studentCoupon = couponMapper.selectStudentCoupon(student.getStdId(), request.getCpId());
        if (studentCoupon == null) {
            couponMapper.insertStudentCoupon(student.getStdId(), request.getCpId(), request.getQuantity());
        } else {
            couponMapper.updateStudentCoupon(student.getStdId(), request.getCpId(), request.getQuantity());
        }

        studentMapper.updateStudentSeed(student.getStdId(), -request.getAmount());
        log.info("====================쿠폰 구매=====================");
        AlarmArgs alarmArgs = new AlarmArgs(AlarmType.COUPON_BUY, couponDTO.getCpName(), student.getStdName());
//        kafkaProducer.send(new AlarmEvent(student.getStdId(), alarmArgs, request.getCpId(), LocalDateTime.now()));
        alarmService.sendAlarm(student.getStdId(), alarmArgs, request.getCpId());
    }

    public List<StudentCouponDTO> getStudentCoupons(Member member) {
        Student student = loadStudentByMember(member);
        List<StudentCouponDTO> studentCoupons = couponMapper.getStudentCoupons(student.getStdId());
        for (StudentCouponDTO studentCoupon : studentCoupons) {
            CouponDTO coupon = couponMapper.getCouponByCpId(studentCoupon.getCpId());
            studentCoupon.setCpName(coupon.getCpName()); // CouponDTO의 이름을 StudentCouponDTO에 추가
        }
        return studentCoupons;
    }

    private Student loadStudentByMember(Member member) {
        return studentMapper.selectStudentByUsernameAndStdName(member.getUsername(), member.getName());
    }


}