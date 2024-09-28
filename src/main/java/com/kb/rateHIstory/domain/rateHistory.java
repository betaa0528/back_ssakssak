package com.kb.rateHIstory.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class rateHistory {
    private long rateHistoryId;
    private Date date;
    private int change;
    private int stockPrice;

}
