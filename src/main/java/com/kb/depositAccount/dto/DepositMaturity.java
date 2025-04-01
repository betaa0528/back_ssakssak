package com.kb.depositAccount.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class DepositMaturity {
    private long accountId;
    private long stdId;
    private long tchId;
    private long depositId;
    private String depositName;
    private int rate;
    private int depositAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private char status;
    private int depositPeriod;
}
