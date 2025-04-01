package com.kb.coupon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentCoupon {
    private long stcpId;
    private long cpId;
    private long stdId;
    private int cpQuantity;
}
