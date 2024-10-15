package com.kb.depositAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepositAccountResponse {
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
}
