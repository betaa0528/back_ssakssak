package com.kb.store.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Store {
    private Long cpId;
    private Long cpPrice;
    private String cpName;
    private String cpContent;
    private Integer cpQuantity;
    private LocalDateTime cpDate;
    private String cpImage;
}
