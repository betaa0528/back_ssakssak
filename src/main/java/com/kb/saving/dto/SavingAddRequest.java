package com.kb.saving.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SavingAddRequest {
    private long savingId;
    private String savingName;
    private String savingContent;
    private int maxDeposit;
    private long savingPeriod;
    private char savingCycle;
    private int rate;
    private int primeRate;
    private char isPrime;
    private String img;
    private List<Long> jobList;
}
