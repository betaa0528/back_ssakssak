package com.kb.saving.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrimeRate {
    private long primeRateId;
    private long savingId;
    private int primeRate;
    private long jobId;

    public PrimeRate(long savingId, int primeRate, long jobId) {
        this.savingId = savingId;
        this.primeRate = primeRate;
        this.jobId = jobId;
    }
}
