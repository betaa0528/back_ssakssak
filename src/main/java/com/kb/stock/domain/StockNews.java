package com.kb.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StockNews {
    private long newsId;
    private String title;
    private String content;
    private Date newsDate;
}
