package com.kb.coupon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponUsageDTO {
    private Long id;
    private Long teacher_id;
    private LocalDate date;
    private String student_name;
    private String coupon_name;
}
