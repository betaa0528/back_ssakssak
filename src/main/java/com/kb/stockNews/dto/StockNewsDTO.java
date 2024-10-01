package com.kb.stockNews.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockNewsDTO {
    private long newsId;
    private String title;
    private String content;
    private Date newsDate;
}
