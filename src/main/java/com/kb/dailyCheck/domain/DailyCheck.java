package com.kb.dailyCheck.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DailyCheck {
    private long checkId;
    private long stdId;
    private long tchId;
    private Date checkDate;
    private char isCheck;
}
