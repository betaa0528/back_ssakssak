package com.kb.coupon.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CouponDTO {
    private Long cpId;
    private String cpName;
    private String cpContent;
    private Integer cpQuantity;
    private Integer cpPrice;
}