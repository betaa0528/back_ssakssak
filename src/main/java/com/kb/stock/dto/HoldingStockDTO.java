package com.kb.stock.dto;

import com.kb.stock.domain.HoldingStock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HoldingStockDTO {
    private long stdId;
    private int totalQuantity;
    private int totalInvestment;
    private double averagePrice;
    private double currentValue;
    private double profitLoss;
    private double profitRate;
    private int seed;

    public static HoldingStockDTO from(HoldingStock holdingStock, int seed) {
        return new HoldingStockDTO(
                holdingStock.getStdId(),
                holdingStock.getTotalQuantity(),
                holdingStock.getTotalInvestment(),
                holdingStock.getAveragePrice(),
                holdingStock.getCurrentValue(),
                holdingStock.getProfitLoss(),
                holdingStock.getProfitRate(),
                seed
        );
    }

}

