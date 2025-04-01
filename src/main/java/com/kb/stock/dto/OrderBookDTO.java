package com.kb.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderBookDTO {

    private List<OrderInfo> buy;
    private List<OrderInfo> sell;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderInfo {
        private int price;
        private int quantity;
    }
}
