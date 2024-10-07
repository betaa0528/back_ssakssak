package com.kb.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockChartDTO {
    private int todayPrice;
    private int priceChange;
    private List<ChartDataDTO> chartData;
    private int highPrice30Days;
    private int lowPrice30Days;
}
