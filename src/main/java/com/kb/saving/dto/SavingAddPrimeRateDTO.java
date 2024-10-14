package com.kb.saving.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SavingAddPrimeRateDTO {
    private long savingId;
    private String savingName;
    private String savingContent;
    private int maxDeposit;
    private long savingPeriod;
    private char savingCycle;
    private int rate;
    private String img;
    private int primeRate;
}
