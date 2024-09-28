package com.kb.coupon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Coupon {
    private long cpId;
    private String cpName;
    private String cpContent;
    private int cpQuantity;
    private int cpPrice;

}
