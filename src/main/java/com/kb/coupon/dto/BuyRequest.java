package com.kb.coupon.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuyRequest {
    private long cpId;
    private int quantity;
    private int price;

    public int getAmount(){
        return quantity * price;
    }
}
