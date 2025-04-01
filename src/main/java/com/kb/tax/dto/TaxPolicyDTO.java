package com.kb.tax.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaxPolicyDTO {
    private long policyId;
    private String policyType;
    private double rate;
}
