package com.kb.stock.domain;

import com.kb.common.enums.OrderStatus;
import com.kb.common.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Insert;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockOrderBook {
    private Long id;
    private Long stdId;
    private Long stockId;
    private OrderType orderType;
    private int quantity;
    private int price;
    private OrderStatus status;
    private LocalDateTime createdAt;
}
