package com.kb.saving.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Saving {
    private long savingId;
    private String savingName;
    private String savingContent;
    private int maxDeposit;
    private long savingPeriod;
    private long savingCycle;
    private int rate;
    private String img;
    private char isPrime;
}
