package com.kb.coupon.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentCouponDTO {
    private long stcpId;
    private long cpId;
    private long stdId;
    private int cpQuantity;
    private String cpName; // 쿠폰 이름 추가
}
