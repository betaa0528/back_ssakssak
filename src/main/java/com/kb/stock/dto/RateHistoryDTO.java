package com.kb.stock.dto;

import com.kb.stock.domain.RateHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RateHistoryDTO {
    private long rateHistoryId;
    private Date stockDate;
    private int change;
    private int stockPrice;

    public static RateHistoryDTO from(RateHistory entity) {
        return new RateHistoryDTO(
                entity.getRateHistoryId(),
                entity.getStockDate(),
                entity.getChange(),
                entity.getStockPrice()
        );
    }
}
