package com.kb.depositAccount.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class DepositAccount {
    private Long accountId;
    private Long stdId;
    private Long tchId;
    private Long depositId;
    private Integer rate;
    private Integer depositAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}