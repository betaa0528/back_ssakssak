package com.kb.stock.dto;

import com.kb.stock.domain.StockNews;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockNewsDTO {
    private long newsId;
    private String title;
    private String content;
    private String newsDate;

    public static StockNewsDTO from(StockNews stockNews) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = format.format(stockNews.getNewsDate());
        return new StockNewsDTO(stockNews.getNewsId(), stockNews.getTitle(), stockNews.getContent(), strDate);
    }

}
