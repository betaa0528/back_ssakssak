package com.kb.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StockTrade {
    private long tradeId;
    private long stdId;
    private long tchId;
    private char tradeType;
    private int quantity;
    private int stockPrice;
    private Date tradeDate;
}
