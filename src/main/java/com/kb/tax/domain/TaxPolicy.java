package com.kb.tax.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaxPolicy {
    private long policyId;
    private String policyType;
    private double rate;
    private String description;
    private LocalDateTime effectiveDate;
}
