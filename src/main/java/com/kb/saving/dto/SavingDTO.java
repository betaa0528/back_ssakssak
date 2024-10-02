package com.kb.saving.dto;

import com.kb.saving.domain.Saving;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
    public class SavingDTO {
        private Long savingId;
        private String product;
        private Integer maxDeposit;
        private Integer depositPeriod;
        private Integer rate;
        private String isPrime;

     }
