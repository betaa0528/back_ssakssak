package com.kb.savingAccount.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SavingAccount {
    private long accountId;
    private long stdId;
    private long tchId;
    private long savingId;
    private int rate;
    private int depositAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private char status;
    private int totalAmount;
}
