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
    private String product;
    private int maxDeposit;
    private int rate;
    private char isPrime;
}
