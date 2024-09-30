package com.kb.saving.dto;

import com.kb.saving.domain.Saving;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
    public class SavingDTO {
//    변환해주는 역할
        private Long savingId;
        private String product;
        private Integer maxDeposit;
        private Integer depositPeriod;
        private Integer rate;
        private String isPrime;

        // Saving 엔티티로 변환하는 메서드
//        public Saving toSaving() {
//            return Saving.builder()
//                    .savingId(this.savingId)  // ID 설정
//                    .product(this.product)    // 상품명 설정
//                    .maxDeposit(this.maxDeposit)  // 최대 예적금 설정
//                    .depositPeriod(this.depositPeriod)  // 예적금 기간 설정 (필드명 확인)
//                    .rate(this.rate)  // 이자율 설정
//                    .isPrime(this.isPrime)  // Prime 여부 설정
//                    .build();
//        }
}
