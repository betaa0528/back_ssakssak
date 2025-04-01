package com.kb.deposit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Deposit {
    private Long depositId;
    private String depositName;
    private String depositContent;
    private Integer maxDeposit;
    private Integer depositPeriod;
    private Integer rate;
}