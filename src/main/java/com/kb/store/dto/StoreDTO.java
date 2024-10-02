package com.kb.store.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StoreDTO {
    private Long storeId;      // store_id 필드
    private Long cpId;         // cp_id 필드 (쿠폰 ID)
    private Long stdId;        // std_id 필드 (학생 ID)
    private LocalDate storeDate;  // store_date 필드 (구매 날짜)
    private Integer quantity;  // quantity 필드 (수량)
}