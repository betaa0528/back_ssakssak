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
    private char
            savingCycle;
    private int rate;
    private String img;
    private char isPrime;

    public Saving(String savingName, String savingContent, int maxDeposit, long savingPeriod, char savingCycle, int rate, String img, char isPrime) {
        this.savingName = savingName;
        this.savingContent = savingContent;
        this.maxDeposit = maxDeposit;
        this.savingPeriod = savingPeriod;
        this.savingCycle = savingCycle;
        this.rate = rate;
        this.img = img;
        this.isPrime = isPrime;
    }
}
