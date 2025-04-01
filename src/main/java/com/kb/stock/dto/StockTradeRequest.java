package com.kb.stock.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kb.student.StudentIdentifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StockTradeRequest implements StudentIdentifiable {
    private Long stdId;
    private String username;
    private String name;
    private int quantity;
    private int stockPrice;

}
