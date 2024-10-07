package com.kb.tax.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Tax {
    private Long taxId;
    private Long stdId;
    private Integer amount;
    private String taxType;
    private Long transactionId;
    private LocalDate transactionDate;
}
