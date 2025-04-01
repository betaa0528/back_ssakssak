package com.kb.stock.dto;

import com.kb.common.enums.OrderStatus;
import com.kb.common.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockOrderBookRequest {
    private Long stdId;
    private Long stockId;
    private OrderType orderType;
    private int quantity;
    private int price;
    private OrderStatus status;
}
