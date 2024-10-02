package com.kb.dailyCheck.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class DailyCheckDTO {
    private Long checkId;
    private Long stdId;
    private Long tchId;
    private LocalDateTime checkDate;
    private String isCheck;
}