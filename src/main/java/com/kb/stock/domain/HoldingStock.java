package com.kb.stock.domain;

import com.kb.common.exception.ErrorCode;
import com.kb.common.exception.SsakssakApplicationException;
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
    private int seed;


    public void validateSellable(int quantity) {
        if(quantity <= 0 || quantity > totalQuantity) {
            throw new SsakssakApplicationException(ErrorCode.INSUFFICIENT_STOCK_QUANTITY);
        }
    }

    public void plusStock(int quantity) {
        this.totalQuantity += quantity;
    }

    public void minusStock(int quantity) {
        this.totalQuantity -= quantity;
    }
}
