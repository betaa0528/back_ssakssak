package com.kb.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RateHistory {
    private long rateHistoryId;
    private Date stockDate;
    private int change;
    private int stockPrice;
}
