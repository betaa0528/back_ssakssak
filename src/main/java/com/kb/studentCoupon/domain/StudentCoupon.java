package com.kb.studentCoupon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentCoupon {
    private long stcpId;
    private long cpId;
    private long stdId;
    private int cpQuantity;
}
