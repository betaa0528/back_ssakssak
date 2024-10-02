package com.kb.rateHistory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RateHistoryDTO {
    private long rateHistoryId;
    private Date date;
    private int change;
    private int stockPrice;
}
