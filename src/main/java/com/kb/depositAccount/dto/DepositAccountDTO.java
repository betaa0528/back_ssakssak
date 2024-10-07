package com.kb.depositAccount.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DepositAccountDTO {
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