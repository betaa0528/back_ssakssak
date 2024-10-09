package com.kb.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockTradeRequest {
    private String username;
    private String name;
    private int quantity;
    private int stockPrice;
}
