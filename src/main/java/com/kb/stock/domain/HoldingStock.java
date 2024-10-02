package com.kb.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HoldingStock {
    private long stdId;
    private int totalQuantity;
    private int totalInvestment;
    private double averagePrice;
    private double currentValue;
    private double profitLoss;
    private double profitRate;
}
