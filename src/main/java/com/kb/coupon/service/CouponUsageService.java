package com.kb.coupon.service;

import com.kb.member.dto.Member;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import com.kb.teacher.domain.Teacher;
import com.kb.teacher.dto.TeacherDTO;
import com.kb.teacher.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CouponUsageService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;

    private final String COUPON_USAGE_PREFIX = "coupon_usage";

    private Student loadStudentByMember(Member member) {
        return studentMapper.selectStudentByUsernameAndStdName(member.getUsername(), member.getName());
    }

    private TeacherDTO loadTeacherByMember(Member member) {
        return teacherMapper.selectByTeacherProfile(member.getUsername());
    }

    public void useCoupon(Member member, String cpName) {
        Student student = loadStudentByMember(member);
        String key = String.format("%s:%d:%s" , COUPON_USAGE_PREFIX, student.getTchId(), LocalDate.now());
        redisTemplate.opsForHash().put(key, student.getStdName(), cpName);
    }

    public Map<Object, Object> getTodayCouponUsage(Member member) {
        TeacherDTO teacher = loadTeacherByMember(member);
        String key = String.format("%s:%d:%s" , COUPON_USAGE_PREFIX, teacher.getTchId(), LocalDate.now());
        return redisTemplate.opsForHash().entries(key);
    }

    public boolean isCouponInUse(Long studentId, Long couponId) {
        String key = String.format("coupon:%d:%d", studentId, couponId);
        return redisTemplate.hasKey(key);
    }

    public void cancelCouponUsage(Long studentId, Long couponId) {
        String key = String.format("coupon:%d:%d", studentId, couponId);
        redisTemplate.delete(key);
    }
}
