package com.kb.store.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class StoreDTO {
    private Long cpId;
    private Long cpPrice;
    private String cpName;
    private String cpContent;
    private Integer cpQuantity;
    private String cpDate;
    private String cpImage;
}