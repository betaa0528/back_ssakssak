package com.kb.depositAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepositAccountRequest {
    private long stdId;
    private long tchId;
    private long depositId;
    private int rate;
    private int depositAmount;
    private LocalDate startDate;
    private LocalDate endDate;
}
