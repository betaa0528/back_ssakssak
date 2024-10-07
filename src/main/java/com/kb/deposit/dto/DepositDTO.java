package com.kb.deposit.dto;

import lombok.Data;

@Data
public class DepositDTO {
    private Long depositId;
    private String depositName;
    private String depositContent;
    private Integer maxDeposit;
    private Integer depositPeriod;
    private Integer rate;
}