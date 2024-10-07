package com.kb.tax.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaxDTO {
    private Long taxId;
    private Long stdId;
    private Integer amount;
    private String taxType;
    private Long transactionId;
    private LocalDate transactionDate;
}