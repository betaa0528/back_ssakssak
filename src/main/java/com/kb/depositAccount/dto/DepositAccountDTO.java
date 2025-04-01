package com.kb.depositAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepositAccountDTO {
    private long depositId;
    private int rate;
    private int depositAmount;
    private LocalDate startDate;
    private LocalDate endDate;
}